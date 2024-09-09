package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.exception.SectionServiceException;
import ro.ubb.abc2024.arheo.repository.SectionRepository;
import ro.ubb.abc2024.utils.validation.GenericValidator;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SectionServiceImpl implements SectionService{

    private final SectionRepository sectionRepository;
    private final GenericValidator<Section> validator;

    @Override
    public Section addSection(Section section) {
        try {
            validator.validate(section);
            return this.sectionRepository.save(section);
        } catch (ConstraintViolationException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public Section updateSection(Section section) {
        var updatedSection = this.sectionRepository.findById(section.getId()).orElseThrow(
                () -> new EntityNotFoundException(String.format("Section with id %d, does not exist.", section.getId())
                ));
        updatedSection.setName(section.getName());
        updatedSection.setSite(section.getSite());
        updatedSection.setCreatedAt(section.getCreatedAt());
        updatedSection.setUpdatedAt(section.getUpdatedAt());
        updatedSection.setStatus(section.getStatus());
        updatedSection.setSouthEast(section.getSouthEast());
        updatedSection.setNorthEast(section.getNorthEast());
        updatedSection.setNorthWest(section.getNorthWest());
        updatedSection.setSouthWest(section.getSouthWest());
        updatedSection.setDimensions(section.getDimensions());
        updatedSection.setArtifactsList(section.getArtifactsList());
        try {
            validator.validate(section);
            return this.sectionRepository.save(updatedSection);
        } catch (ConstraintViolationException ex){
            throw new SectionServiceException(ex.getMessage());
        }
    }

    @Override
    public void deleteSection(long id) {
        try {
            this.sectionRepository.deleteById(id);
        } catch (Exception ex){
            throw new SectionServiceException(ex.getMessage());
        }
    }

    @Override
    public Section getSection(String name) {
        return this.sectionRepository.getSectionsByNameIs(name).orElseThrow(
                () -> new EntityNotFoundException(String.format("Section with name %s, does not exist.", name)
                ));
    }

    @Override
    public Section getSection(long id) {
        return this.sectionRepository.getSectionByIdWithArtifacts(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Section with id %d, does not exist.", id)
                ));
    }

    @Override
    public List<Section> getSectionsAroundPoint(double latitude, double longitude, double radius) {
        // considering the point described by latitude and longitude as the center of a circle
        // with the given radius, return all the sections that have their center inside the circle
        List<Section> sections = this.sectionRepository.findAll();
        for (Section section : sections) {
            // calculate the distance between the center of the circle and the center of the section
            double centerLatitude = (section.getNorthWest().getLatitude() + section.getSouthEast().getLatitude()) / 2;
            double centerLongitude = (section.getNorthWest().getLongitude() + section.getSouthEast().getLongitude()) / 2;
            double distance = Math.sqrt(Math.pow(centerLatitude - latitude, 2) + Math.pow(centerLongitude - longitude, 2));
            if (distance > radius) {
                sections.remove(section);
            }
        }
        return sections;
    }

    @Override
    public List<Section> getSectionsNorthOf(double latitude) {
        List<Section> sections = this.sectionRepository.findAll();
        sections.removeIf(section -> section.getNorthWest().getLatitude() < latitude && section.getNorthEast().getLatitude() < latitude);
        return sections;
    }

    @Override
    public List<Section> getSectionsSouthOf(double latitude) {
        List<Section> sections = this.sectionRepository.findAll();
        sections.removeIf(section -> section.getSouthWest().getLatitude() > latitude && section.getSouthEast().getLatitude() > latitude);
        return sections;
    }

    @Override
    public List<Section> getSectionsWestOf(double longitude) {
        List<Section> sections = this.sectionRepository.findAll();
        sections.removeIf(section -> section.getSouthWest().getLongitude() > longitude && section.getNorthWest().getLongitude() > longitude);
        return sections;
    }

    @Override
    public List<Section> getSectionsEastOf(double longitude) {
        List<Section> sections = this.sectionRepository.findAll();
        sections.removeIf(section -> section.getSouthEast().getLongitude() < longitude && section.getNorthEast().getLongitude() < longitude);
        return sections;
    }

    @Override
    public List<Section> getSectionsDeeperThan(double depth){
        List<Section> sections = this.sectionRepository.findAll();
        sections.removeIf(section -> section.getDimensions().getDepth() < depth);
        return sections;
    }

    @Override
    public List<Section> getSectionsShallowerThan(double depth){
        List<Section> sections = this.sectionRepository.findAll();
        sections.removeIf(section -> section.getDimensions().getDepth() > depth);
        return sections;
    }

    @Override

    public List<Section> getSections() {
        //return this.sectionRepository.findAll();
        return this.sectionRepository.getSectionsWithArtifacts(null).getContent();
    }


//    @Override
//    public List<Section> getSections(int page, int pageSize) {
//        Pageable pageable = PageRequest.of(page - 1, pageSize);
//        return this.sectionRepository.getSectionsWithArtifacts(pageable).getContent();
//    }

    @Override
    public Page<Section> getSections(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.sectionRepository.getSectionsWithArtifacts(pageable);
    }

    @Override
    public Page<Section> findAllByCriteria(Long sectionId, String sectionName, Long siteId, String status, Double minDepth, Double maxDepth, Pageable pageable) {
        return sectionRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            root.fetch("artifactsList", JoinType.LEFT);

            if (sectionId != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), sectionId));
            }
            if (sectionName != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + sectionName + "%"));
            }
            // for the site id, we need to join the site table
            if (siteId != null) {
                Join<Section, Site> siteJoin = root.join("site");
                predicates.add(criteriaBuilder.equal(siteJoin.get("id"), siteId));
            }
            if (status != null) {
                // predicates.add(criteriaBuilder.equal(root.get("status"), status));
                // status is SectionStatus, not String. We need to convert it
                if(status.equals("INCOMPLETE")){
                    predicates.add(criteriaBuilder.notEqual(root.get("status"), SectionStatus.COMPLETED));
                } else {
                    predicates.add(criteriaBuilder.equal(root.get("status"), SectionStatus.valueOf(status)));
                }
            }
            if (minDepth != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dimensions").get("depth"), minDepth));
            }
            if (maxDepth != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dimensions").get("depth"), maxDepth));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    @Override
    public List<Section> getIncompleteSections() {
        return this.sectionRepository.getSectionsByStatusIsNot(SectionStatus.COMPLETED);
    }

    @Override
    public List<Section> getSectionsBySite(long siteId) {
        return this.sectionRepository.getSectionsBySiteId(siteId);
    }

    @Override
    public List<Section> getSectionsByStatusIsAndSiteId(String status, long siteId) {
        // make string into enum
        SectionStatus sectionStatus = SectionStatus.valueOf(status);
        return this.sectionRepository.getSectionsByStatusIsAndSiteId(sectionStatus, siteId);
    }

    @Override
    public List<Artifact> getArtifactsFromSection(long sectionId) {
        return this.sectionRepository.getSectionByIdWithArtifacts(sectionId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Section with id %d, does not exist.", sectionId)
                )).getArtifactsList();
    }

    @Override
    public List<Artifact> getArtifactsFromSectionByArchaeologist(long sectionId, long archaeologistId) {
        List<Artifact> artifacts = this.sectionRepository.getSectionByIdWithArtifacts(sectionId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Section with id %d, does not exist.", sectionId)
                )).getArtifactsList();
        artifacts.removeIf(artifact -> artifact.getArcheologist().getId() != archaeologistId);
        return artifacts;
    }

    @Override
    public Long getMainArchaeologistIdFromSectionId(long sectionId) {
        return this.sectionRepository.getMainArchaeologistIdFromSectionId(sectionId);
    }

    @Override
    public void updateSectionDepth(long sectionId, double depth) {
        Section section = this.sectionRepository.findById(sectionId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Section with id %d, does not exist.", sectionId)
                ));
        section.getDimensions().setDepth(depth);
        this.sectionRepository.save(section);
    }

}
