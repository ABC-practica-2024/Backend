package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    @Query(value = "select a from Artifact a join a.section s join s.site si join si.archaelogists ar where si.id = :siteId and ar.id = :archaeologistId")
    List<Artifact> getArtifactsBySiteIdAndArchaeologistId(Long siteId, Long archaeologistId);

}
