package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.arheo.domain.Status;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.repository.SiteRequestRepository;
import ro.ubb.abc2024.arheo.utils.dto.ArheologicalSiteRequestDto;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SiteService {
    @Autowired
    SiteRequestRepository siteRequestRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SiteRepository siteRepository;

    public CreateArchaeologicalSiteRequest getCreateArchaeologicalSiteRequestById(long id){
        return this.siteRequestRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("Create Archaeological Site Request with id %d, not found",id)));


    }
    public void deleteCreateArchaeologicalSiteRequest(long id){
        this.siteRequestRepository.deleteById(id);
    }

    public CreateArchaeologicalSiteRequest requestCreateArcheologicalSite(CreateArchaeologicalSiteRequest requestToBeAdded) {
        var archeologist = this.userRepository.findById(requestToBeAdded.getArcheologist().getId()).orElseThrow(() ->
                new EntityNotFoundException(String.format("User with id %d not found", requestToBeAdded.getArcheologist().getId())));
        requestToBeAdded.setArcheologist(archeologist);
        return siteRequestRepository.save(requestToBeAdded);
    }

    public List<CreateArchaeologicalSiteRequest> getAllSiteRequests() {
        return siteRequestRepository.findAll();
    }

    public List<CreateArchaeologicalSiteRequest> getPendingSiteRequests() {
        return siteRequestRepository.findByStatus(Status.PENDING);
    }

    public CreateArchaeologicalSiteRequest solveCreateSiteRequest(long id) {
        CreateArchaeologicalSiteRequest request = siteRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Create Archaeological Site Request with id %d not found", id)));

        if (!request.getStatus().equals(Status.PENDING)) {
            throw new IllegalStateException("Request is not in PENDING and cannot be solved.");
        }

        // Create a new Site based on the request
        Site newSite = Site.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .centerCoordinates(request.getCenterCoordinates())
                .perimeterCoordinates(request.getPerimeterCoordinates())
                .status(SiteStatus.DIGGING)
                .createdAt(LocalDateTime.now())
                .sections(Collections.emptyList())
                .mainArchaeologist(request.getArcheologist())
                .archaeologists(Collections.emptyList())
                .build();

        siteRepository.save(newSite);

        // Update request status and solveRequestTime
        request.setStatus(Status.ACCEPTED);
        request.setSolveRequestTime(LocalDateTime.now());
        siteRequestRepository.save(request);

        return request;
    }

}