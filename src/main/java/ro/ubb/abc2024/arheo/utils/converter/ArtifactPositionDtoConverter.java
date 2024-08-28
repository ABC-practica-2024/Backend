package ro.ubb.abc2024.arheo.utils.converter;

import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.artifact.ArtifactPosition;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactPositionDto;
import ro.ubb.abc2024.utils.converter.Converter;

@Component
public class ArtifactPositionDtoConverter implements Converter<ArtifactPosition, ArtifactPositionDto> {
    @Override
    public ArtifactPosition createFromDto(ArtifactPositionDto dto) {
        return ArtifactPosition.builder()
                .latitude(dto.latitude())
                .longitude(dto.longitude())
                .depth(dto.depth())
                .build();
    }

    @Override
    public ArtifactPositionDto createFromEntity(ArtifactPosition entity) {
        return new ArtifactPositionDto(
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getDepth()
        );
    }
}
