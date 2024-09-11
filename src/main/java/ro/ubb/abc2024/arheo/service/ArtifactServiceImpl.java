package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.artifact.ImageToArtifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.exception.ArtifactServiceException;
import ro.ubb.abc2024.arheo.repository.ArtifactRepository;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.utils.validation.GenericValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ArtifactServiceImpl implements ArtifactService {
    private final ArtifactRepository artifactRepository;
    private final GenericValidator<Artifact> validator;

    @Override
    public Artifact getArtifactById(Long id) {
        return artifactRepository.getArtifactsByIdWithImages(id).orElseThrow(() -> new EntityNotFoundException(String.format("Artifact with id: %d, not found", id)));
    }

    @Override
    public Artifact addArtifact(Artifact artifact, User archaeologist) {
        try {
            validator.validate(artifact);
            // the issues mentioned the labScan should be null and analysisComplete false
            artifact.setLabScan(null);
            artifact.setAnalysisCompleted(false);
            artifact.setArcheologist(archaeologist);
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
        try {
            validator.validate(artifact);

            updatedArtifact.setDimension(artifact.getDimension());
            updatedArtifact.setPosition(artifact.getPosition());
            updatedArtifact.setRotation(artifact.getRotation());
            updatedArtifact.setLabel(artifact.getLabel());
            updatedArtifact.setCategory(artifact.getCategory());
            updatedArtifact.setAnalysisCompleted(false); // I did the same here for update
            updatedArtifact.setSection(artifact.getSection());
            updatedArtifact.setLabScan(null); // and here

            return artifactRepository.save(updatedArtifact);
        } catch (ConstraintViolationException ex) {
            throw new ArtifactServiceException(ex.getMessage());
        }

    }

    @Override
    public Page<Artifact> getAllPaginatedByCriteria(Long artifactId, Long siteId, Long sectionId, Long archaeologistId, String label, String category, Boolean analysisCompleted, Pageable pageable) {
        return artifactRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (artifactId != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), artifactId));
            }
            if (siteId != null) {
                Join<Artifact, Section> artifactSectionJoin = root.join("section");
                Join<Section, Site> sectionSiteJoin = artifactSectionJoin.join("site");
                predicates.add(criteriaBuilder.equal(sectionSiteJoin.get("id"), siteId));
            }
            if (sectionId != null) {
                Join<Artifact, Section> artifactSectionJoin = root.join("section");
                predicates.add(criteriaBuilder.equal(artifactSectionJoin.get("id"), sectionId));
            }
            if (archaeologistId != null) {
                Join<Artifact, User> artifactUserJoin = root.join("archeologist");
                predicates.add(criteriaBuilder.equal(artifactUserJoin.get("id"), archaeologistId));
            }
            if (label != null) {
                predicates.add(criteriaBuilder.like(root.get("label"),  "%" + label + "%"));
            }
            if (category != null) {
                predicates.add(criteriaBuilder.equal(root.get("category"), category));
            }
            if (analysisCompleted != null) {
                predicates.add(criteriaBuilder.equal(root.get("analysisCompleted"), analysisCompleted));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    @Override
    public Long getMainArchaeologistIdFromArtifactId(Long id) {
        return artifactRepository.findMainArcheologistIdByArtifactId(id);
    }

    @Override
    public List<Long> getAssignedArchaeologistIdsBySectionId(Long id) {
        List<User> archaeologists = artifactRepository.findAssignedArchaeologistIdsBySectionId(id);
        return archaeologists.stream().map(User::getId).toList();
    }

    @Override
    public Long getMainArchaeologistIdFromSectionId(Long id) {
        return artifactRepository.findMainArcheologistIdBySectionId(id);
    }
}
