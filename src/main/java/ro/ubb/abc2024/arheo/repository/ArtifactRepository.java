package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.user.User;

import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long>, JpaSpecificationExecutor<Artifact> {
    List<Artifact> findArtifactsByLabScanIsNull();
    //List<Artifact> findArtifactsByArcheologist(User archeologist);
    List<Artifact> findArtifactsByArcheologist_Id(Long id);
    List<Artifact> findArtifactsBySection_Id(Long id);
    List<Artifact> findArtifactsBySection_Site_Id(Long id);
    List<Artifact> findArtifactsByCategory(String category);
    List<Artifact> findArtifactsBySection_Site_IdAndArcheologist_Id(Long siteId, Long archeologistId);
    @Query("select a.section.site.mainArchaeologist.id from Artifact a where a.id = :id")
    Long findMainArcheologistIdByArtifactId(@Param("id") Long id);
    @Query("select a.section.site.mainArchaeologist.id from Artifact a where a.section.id = :id")
    Long findMainArcheologistIdBySectionId(@Param("id") Long id);
    @Query("SELECT a.section.site.archaeologists from Artifact a WHERE a.section.id = :id")
    List<User> findAssignedArchaeologistIdsBySectionId(@Param("id") Long id);
}
