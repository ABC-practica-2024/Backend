package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.arheo.domain.artifact.ImageToArtifact;

public interface ImageToArtifactRepository extends JpaRepository<ImageToArtifact, Long> {

}
