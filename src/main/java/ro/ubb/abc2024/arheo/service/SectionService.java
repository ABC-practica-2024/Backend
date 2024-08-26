package ro.ubb.abc2024.arheo.service;

import jakarta.transaction.Transactional;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
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
    @Transactional
    List<Section> getSections();
    List<Section> getSectionsBySite(long siteId);
    List<Section> getSectionsByStatusIsAndSiteId(String status, long siteId);
    List<Artifact> getArtifactsFromSection(long sectionId);
    List<Artifact> getArtifactsFromSectionByArchaeologist(long sectionId, long archaeologistId);
}
