package ro.ubb.abc2024.arheo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.user.User;

import java.util.List;

public interface ArtifactService {
    Artifact getArtifactById(Long id);
    Artifact addArtifact(Artifact artifact, User archaeologist);
    void deleteArtifact(Long id);
    Artifact updateArtifact(Artifact updatedArtifact);
    Page<Artifact> getAllPaginatedByCriteria(Long artifactId, Long siteId, Long sectionId, Long archaeologistId, String label, String category, Boolean analysisCompleted, Pageable pageable);
    Long getMainArchaeologistIdFromArtifactId(Long id);
    List<Long> getAssignedArchaeologistIdsBySectionId(Long id);
    Long getMainArchaeologistIdFromSectionId(Long id);

}