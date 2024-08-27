package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.user.User;

import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    List<Artifact> findArtifactsByLabScanIsNull();
    // we have 2 options here for user, we will decide later which one to keep
    List<Artifact> findArtifactsByUser(User user);
    List<Artifact> findArtifactsByUser_Id(Long id);
    List<Artifact> findArtifactsBySection_Id(Long id);
    List<Artifact> findArtifactsBySection_Site_Id(Long id);
    @Query("SELECT a FROM Artifact a " +
            "JOIN a.section s " +
            "JOIN s.site si " +
            "JOIN si.archaelogists ar " +
            "WHERE si.id = :siteId AND ar.id = :archaeologistId")
    List<Artifact> getArtifactsBySiteIdAndArchaeologistId(@Param("siteId") Long siteId, @Param("archaeologistId") Long archaeologistId);
    List<Artifact> findArtifactsByCategory(String category);
}
