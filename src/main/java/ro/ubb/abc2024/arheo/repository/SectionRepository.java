package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Long> {

    // most of the methods are self-explanatory;
    // those which have a query are related to Lazy Loading

    // get Section by name
    @Query(value = "SELECT s FROM Section s LEFT JOIN FETCH s.artifactsList WHERE s.name = ?1")
    public Optional<Section> getSectionsByNameIs(String name);

    // get Section by partial name
    public List<Section> getSectionsByNameContainingIgnoreCase(String name);

    // get Sections by site id
    @Query(value = "SELECT s FROM Section s LEFT JOIN FETCH s.artifactsList WHERE s.site.id = ?1")
    public List<Section> getSectionsBySiteId(Long siteId); // not sure if this works

    // get Sections by site title
    public List<Section> getSectionsBySiteTitle(String siteTitle);

    // get Sections created later than a certain datetime
    public List<Section> getSectionsByCreatedAtAfter(LocalDateTime dateTime);

    // get Sections created earlier than a certain datetime
    public List<Section> getSectionsByCreatedAtBefore(LocalDateTime dateTime);

    // get Sections with given status and given siteId
    @Query(value = "SELECT s FROM Section s LEFT JOIN FETCH s.artifactsList WHERE s.status = ?1 AND s.site.id = ?2")
    public List<Section> getSectionsByStatusIsAndSiteId(SectionStatus status, Long site_id);

    // get Sections with given status
    public List<Section> getSectionsByStatusIs(SectionStatus status);
    @Query(value = "SELECT s FROM Section s LEFT JOIN FETCH s.artifactsList WHERE s.status != ?1")
    public List<Section> getSectionsByStatusIsNot(SectionStatus status);
    public Optional<Section> getSectionByNameIs(String testSection);

    @Query(value = "SELECT s FROM Section s LEFT JOIN FETCH s.artifactsList")
    public List<Section> getSectionsWithArtifacts();

    // get Section by id, with artifacts
    @Query(value = "SELECT s FROM Section s LEFT JOIN FETCH s.artifactsList WHERE s.id = ?1")
    public Optional<Section> getSectionByIdWithArtifacts(Long id);
    // get Section by id, with artifacts


}
