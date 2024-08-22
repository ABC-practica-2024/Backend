package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.repository.ArtifactRepository;
import ro.ubb.abc2024.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArtifactServiceImpl implements ArtifactService {
    private final ArtifactRepository artifactRepository;

    @Override
    public List<Artifact> getAllArtifacts() {
        return artifactRepository.findAll();
    }

    @Override
    public Artifact getArtifactById(Long id) {
        return artifactRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Artifact with id: %d, not found", id))
                );
    }

    @Override
    public Artifact addArtifact(Artifact artifact) {
        // the issues mentioned the labScan should be null and analysisComplete false
        artifact.setLabScan(null);
        artifact.setAnalysisCompleted(false);
        return artifactRepository.save(artifact);
    }

    @Override
    @Transactional
    public void deleteArtifact(Long id) {
        artifactRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Artifact updateArtifact(Long id, Artifact artifact) {
        var updatedArtifact = this.artifactRepository.
                findById(artifact.getId()).
                orElseThrow(
                        () -> new EntityNotFoundException(String.format("Artifact with id %d, does not exist.", artifact.getId())
                ));
        updatedArtifact.setDimension(artifact.getDimension());
        updatedArtifact.setPosition(artifact.getPosition());
        updatedArtifact.setRotation(artifact.getRotation());
        updatedArtifact.setLabel(artifact.getLabel());
        updatedArtifact.setCategory(artifact.getCategory());
        updatedArtifact.setAnalysisCompleted(false); // I did the same here for update
        updatedArtifact.setThumbnail(artifact.getThumbnail());
        updatedArtifact.setSection(artifact.getSection());
        updatedArtifact.setUser(artifact.getUser());
        updatedArtifact.setLabScan(null); // and here
        return artifactRepository.save(updatedArtifact);
    }

    @Override
    public List<Artifact> getUnanalysedArtifacts() {
        return artifactRepository.findArtifactByLabScanIsNull();
    }

    @Override
    public List<Artifact> getArtifactByUser(User user) {
        return artifactRepository.findArtifactByUser(user);
    }
}
