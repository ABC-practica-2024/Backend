package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.site.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.repository.SiteRequestRepository;
import ro.ubb.abc2024.arheo.utils.dto.SiteDTO;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SiteServiceImpl implements SiteService{
    @Autowired
    private SectionService sectionService;

    private final SiteRepository siteRepository;

    @Autowired
    SiteRequestRepository siteRequestRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<Site> getAll(){
        return siteRepository.getSitesWithSectionsAndArchaeologists();
    }

    public Page<Site> getAllPaginatedByCriteria(String status, Pageable pageable) {
        return siteRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            root.fetch("sections", JoinType.LEFT);

            if (status != null) {
                if(status.equals("INCOMPLETE")){
                    predicates.add(criteriaBuilder.notEqual(root.get("status"), SectionStatus.COMPLETED));
                } else {
                    predicates.add(criteriaBuilder.equal(root.get("status"), SectionStatus.valueOf(status)));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public List<Site> getAllByStatus(SiteStatus status){
        return siteRepository.getSitesByStatus(status);
    }

    public Site getSiteByTitle(String title){
        return siteRepository.getSiteByTitle(title);
    }

    public Site addSite(Site site){
        return siteRepository.save(site);
    }

    public void deleteSite(Long id){
        siteRepository.deleteById(id);
    }

    public Site getSite(Long id){
        return siteRepository.getSiteById(id);
    }

    @Transactional
    public Site updateSite(long siteId, SiteDTO newSite){

        var updateSite = this.siteRepository.findById(siteId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Site with id %d, does not exist.", siteId)
                ));
        updateSite.setTitle(newSite.title());
        updateSite.setDescription(newSite.description());
        updateSite.setStatus(newSite.status());

        return this.siteRepository.save(updateSite);
    }

    public List<Section> getSectionsBySiteId(Long siteId){
        return siteRepository.getSiteById(siteId).getSections();
    }

    public List<Section> getSectionsBySiteIdAndStatus(Long siteId, SectionStatus status){
        return sectionService.getSectionsByStatusIsAndSiteId(status.name(), siteId);
    }

    public CreateArchaeologicalSiteRequest getCreateArchaeologicalSiteRequest(Long id){
        return this.siteRequestRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("Create Archaeological Site Request with id %d, not found",id)));


    }
    public void deleteCreateArchaeologicalSiteRequest(Long id){
        this.siteRequestRepository.deleteById(id);
    }

    public CreateArchaeologicalSiteRequest requestCreateArchaeologicalSite(CreateArchaeologicalSiteRequest requestToBeAdded) {
        var archeologist = this.userRepository.findById(requestToBeAdded.getArcheologist().getId()).orElseThrow(() ->
                new EntityNotFoundException(String.format("User with id %d not found", requestToBeAdded.getArcheologist().getId())));
        requestToBeAdded.setArcheologist(archeologist);
        return siteRequestRepository.save(requestToBeAdded);
    }

    public List<CreateArchaeologicalSiteRequest> getAllSiteRequests() {
        return siteRequestRepository.findAll();
    }

    public List<CreateArchaeologicalSiteRequest> getPendingSiteRequests() {
        return siteRequestRepository.findByStatus(RequestStatus.PENDING);
    }

    public CreateArchaeologicalSiteRequest solveCreateSiteRequest(Long id) {
        CreateArchaeologicalSiteRequest request = siteRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Create Archaeological Site Request with id %d not found", id)));

        if (!request.getStatus().equals(RequestStatus.PENDING)) {
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
        request.setStatus(RequestStatus.ACCEPTED);
        request.setSolveRequestTime(LocalDateTime.now());
        siteRequestRepository.save(request);

        return request;
    }

}
