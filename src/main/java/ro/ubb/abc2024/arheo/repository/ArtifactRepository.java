package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.user.User;

import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    List<Artifact> findArtifactByLabScanIsNull();
    List<Artifact> findArtifactByUser(User user);
}
