package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.exception.ArtifactServiceException;
import ro.ubb.abc2024.arheo.repository.ArtifactRepository;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.utils.validation.GenericValidator;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArtifactServiceImpl implements ArtifactService {
    private final ArtifactRepository artifactRepository;
    private final GenericValidator<Artifact> validator;

    @Override
    public List<Artifact> getAllArtifacts() {
        return artifactRepository.findAll();
    }

    @Override
    public Artifact getArtifactById(Long id) {
        return artifactRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Artifact with id: %d, not found", id)));
    }

    @Override
    public Artifact addArtifact(Artifact artifact) {
        try {
            validator.validate(artifact);
            // the issues mentioned the labScan should be null and analysisComplete false
            artifact.setLabScan(null);
            artifact.setAnalysisCompleted(false);
            return artifactRepository.save(artifact);
        } catch (ConstraintViolationException ex) {
            throw new ArtifactServiceException(ex.getMessage());
        }
    }

    @Override
    public void deleteArtifact(Long id) {
        artifactRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Artifact updateArtifact(Artifact artifact) {
        var updatedArtifact = this.artifactRepository.findById(artifact.getId()).orElseThrow(() -> new EntityNotFoundException(String.format("Artifact with id %d, does not exist.", artifact.getId())));
        updatedArtifact.setDimension(artifact.getDimension());
        updatedArtifact.setPosition(artifact.getPosition());
        updatedArtifact.setRotation(artifact.getRotation());
        updatedArtifact.setLabel(artifact.getLabel());
        updatedArtifact.setCategory(artifact.getCategory());
        updatedArtifact.setAnalysisCompleted(false); // I did the same here for update
        updatedArtifact.setThumbnail(artifact.getThumbnail());
        updatedArtifact.setSection(artifact.getSection());
        updatedArtifact.setArcheologist(artifact.getArcheologist());
        updatedArtifact.setLabScan(null); // and here
        try {
            validator.validate(artifact);
            return artifactRepository.save(updatedArtifact);
        } catch (ConstraintViolationException ex) {
            throw new ArtifactServiceException(ex.getMessage());
        }

    }

    @Override
    public List<Artifact> getUnanalysedArtifacts() {
        return artifactRepository.findArtifactsByLabScanIsNull();
    }

    @Override
    public List<Artifact> getArtifactsByArcheologistId(Long id) {
        return artifactRepository.findArtifactsByArcheologist_Id(id);
    }

    @Override
    public List<Artifact> getArtifactsBySectionId(Long id) {
        return artifactRepository.findArtifactsBySection_Id(id);
    }

    @Override
    public List<Artifact> getArtifactsBySiteId(Long id) {
        return artifactRepository.findArtifactsBySection_Site_Id(id);
    }

    @Override
    public List<Artifact> getArtifactsBySiteIdAndArcheologistId(Long siteId, Long archeologistId) {
        return artifactRepository.findArtifactsBySection_Site_IdAndArcheologist_Id(siteId, archeologistId);
    }

    @Override
    public List<Artifact> getArtifactsByCategory(String category) {
        return artifactRepository.findArtifactsByCategory(category);
    }
}
