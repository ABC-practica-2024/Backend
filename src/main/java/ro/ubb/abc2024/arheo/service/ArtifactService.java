package ro.ubb.abc2024.arheo.service;

import ro.ubb.abc2024.arheo.domain.artifact.Artifact;

import java.util.List;

public interface ArtifactService {
    List<Artifact> getAllArtifacts();
    Artifact getArtifactById(Long id);
    Artifact addArtifact(Artifact artifact);
    void deleteArtifact(Long id);
    Artifact updateArtifact(Artifact updatedArtifact);
    List<Artifact> getUnanalysedArtifacts();
    List<Artifact> getArtifactsByArcheologistId(Long id);
    List<Artifact> getArtifactsBySectionId(Long id);
    List<Artifact> getArtifactsBySiteId(Long id);
    List<Artifact> getArtifactsBySiteIdAndArcheologistId(Long siteId, Long archeologistId);
    List<Artifact> getArtifactsByCategory(String category);
}