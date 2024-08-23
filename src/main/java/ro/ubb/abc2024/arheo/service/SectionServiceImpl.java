package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.exception.SectionServiceException;
import ro.ubb.abc2024.arheo.repository.SectionRepository;
import ro.ubb.abc2024.utils.validation.GenericValidator;

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
        return this.sectionRepository.findById(id).orElseThrow(
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
    public List<Section> getSections() {
        return this.sectionRepository.findAll();
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
        return this.sectionRepository.findById(sectionId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Section with id %d, does not exist.", sectionId)
                )).getArtifactsList();
    }

    @Override
    public List<Artifact> getArtifactsFromSectionByArchaeologist(long sectionId, long archaeologistId) {
        List<Artifact> artifacts = this.sectionRepository.findById(sectionId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Section with id %d, does not exist.", sectionId)
                )).getArtifactsList();
        artifacts.removeIf(artifact -> artifact.getUser().getId() != archaeologistId);
        return artifacts;
    }
}
