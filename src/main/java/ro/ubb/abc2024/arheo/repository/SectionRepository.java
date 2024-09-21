package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Long>, JpaSpecificationExecutor<Section> {

    // most of the methods are self-explanatory;
    // those which have a query are related to Lazy Loading

    @EntityGraph(attributePaths = {"artifactsList"})
    Page<Section> findAll(Specification<Section> spec, Pageable pageable);

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
    public Page<Section> getSectionsWithArtifacts(Pageable pageable);

    // get Section by id, with artifacts
    @Query(value = "SELECT s FROM Section s LEFT JOIN FETCH s.artifactsList WHERE s.id = ?1")
    public Optional<Section> getSectionByIdWithArtifacts(Long id);

    // get the id of the main archaeologist of a section, through the site
    @Query(value = "SELECT s.site.mainArchaeologist.id FROM Section s WHERE s.id = ?1")
    public Long getMainArchaeologistIdFromSectionId(Long sectionId);
    @Query("SELECT a FROM Artifact a LEFT JOIN FETCH a.images WHERE a.section.id = :sectionId AND a.archeologist.id = :archaeologistId")
    List<Artifact> findArtifactsBySectionIdAndArchaeologistId(@Param("sectionId") Long sectionId, @Param("archaeologistId") Long archaeologistId);

}
