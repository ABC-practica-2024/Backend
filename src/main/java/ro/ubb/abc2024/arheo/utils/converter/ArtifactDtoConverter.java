package ro.ubb.abc2024.arheo.utils.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.artifact.ImageToArtifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.repository.SectionRepository;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactDto;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.converter.Converter;
import ro.ubb.abc2024.utils.file.DbFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@Component
public class ArtifactDtoConverter implements Converter<Artifact, ArtifactDto> {
    private final SectionRepository sectionRepository;
    private final UserRepository userRepository;

    @Override
    public Artifact createFromDto(ArtifactDto dto) {
        Section section = sectionRepository.findById(dto.sectionId()).orElseThrow();
        User archeologist = userRepository.findById(dto.archeologistId()).orElseThrow();

        return Artifact.builder()
                .id(dto.id())
                .dimension(new ArtifactDimensionDtoConverter().createFromDto(dto.artifactDimension()))
                .position(new ArtifactPositionDtoConverter().createFromDto(dto.artifactPosition()))
                .rotation(new ArtifactRotationDtoConverter().createFromDto(dto.artifactRotation()))
                .label(dto.label())
                .category(dto.category())
                .analysisCompleted(dto.analysisComplete())
                .section(section)
                .images(new ArrayList<>())
                .archeologist(archeologist)
                .labScan(null)
                .model3D(null)
                .thumbnail(null)
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .build();

    }

    @Override
    public ArtifactDto createFromEntity(Artifact entity) {
        UUID thumbnailId = entity.getThumbnail() != null ? entity.getThumbnail().getId() : null;
        UUID model3DId = entity.getModel3D() != null ? entity.getModel3D().getId() : null;
        List<UUID> imageIds = !entity.getImages().isEmpty()
                ? entity.getImages().stream().map(imageToArtifact -> imageToArtifact.getDbFile().getId()).collect(Collectors.toList())
                : new ArrayList<>();

        return new ArtifactDto(
                entity.getId(),
                new ArtifactDimensionDtoConverter().createFromEntity(entity.getDimension()),
                new ArtifactPositionDtoConverter().createFromEntity(entity.getPosition()),
                new ArtifactRotationDtoConverter().createFromEntity(entity.getRotation()),
                entity.getLabel(),
                entity.getCategory(),
                entity.isAnalysisCompleted(),
                thumbnailId,
                model3DId,
                imageIds,
                entity.getSection().getId(),
                entity.getArcheologist().getId(),
                //entity.getLabScan().getId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
