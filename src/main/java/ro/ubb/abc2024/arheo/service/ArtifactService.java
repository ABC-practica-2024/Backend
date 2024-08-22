package ro.ubb.abc2024.arheo.service;

import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.user.User;

import java.util.List;

public interface ArtifactService {
    List<Artifact> getAllArtifacts();
    Artifact getArtifactById(Long id);
    Artifact addArtifact(Artifact artifact);
    void deleteArtifact(Long id);
    Artifact updateArtifact(Long id, Artifact updatedArtifact);
    List<Artifact> getUnanalysedArtifacts();
    List<Artifact> getArtifactsByUser(User user);
    List<Artifact> getArtifactsBySectionId(Long id);
    List<Artifact> getArtifactsBySiteId(Long id);
    List<Artifact> getArtifactsBySiteIdAndArcheologistId(Long siteId, Long archeologistId);
}