package ro.ubb.abc2024.arheo.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;

import java.util.List;

public interface SectionService {

    Section addSection(Section section);
    Section updateSection(Section section);
    void deleteSection(long id);
    Section getSection(String name);
    Section getSection(long id);
    List<Section> getSectionsAroundPoint(double latitude, double longitude, double radius);
    List<Section> getSectionsNorthOf(double latitude);
    List<Section> getSectionsSouthOf(double latitude);
    List<Section> getSectionsWestOf(double longitude);
    List<Section> getSectionsEastOf(double longitude);

    List<Section> getSections();

    Page<Section> getSections(int page, int pageSize);

    Page<Section> findAllByCriteria(Long sectionId, String sectionName, Long siteId, String status, Pageable pageable);

    List<Section> getIncompleteSections();
    List<Section> getSectionsBySite(long siteId);
    List<Section> getSectionsByStatusIsAndSiteId(String status, long siteId);
    @Query(value = "SELECT a FROM Artifact a WHERE a.section.id = ?1")
    List<Artifact> getArtifactsFromSection(long sectionId);
    List<Artifact> getArtifactsFromSectionByArchaeologist(long sectionId, long archaeologistId);
}
