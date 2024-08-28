package ro.ubb.abc2024.arheo.utils.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.repository.SectionRepository;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactDto;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.converter.Converter;


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
                .thumbnail(dto.thumbnail())
                .section(section)
                .archeologist(archeologist)
                .labScan(null)
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .build();

    }

    @Override
    public ArtifactDto createFromEntity(Artifact entity) {
        return new ArtifactDto(
                entity.getId(),
                new ArtifactDimensionDtoConverter().createFromEntity(entity.getDimension()),
                new ArtifactPositionDtoConverter().createFromEntity(entity.getPosition()),
                new ArtifactRotationDtoConverter().createFromEntity(entity.getRotation()),
                entity.getLabel(),
                entity.getCategory(),
                entity.isAnalysisCompleted(),
                entity.getThumbnail(),
                entity.getSection().getId(),
                entity.getArcheologist().getId(),
                //entity.getLabScan().getId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
