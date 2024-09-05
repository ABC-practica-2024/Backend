package ro.ubb.abc2024.arheo.utils.converter;

import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.artifact.ArtifactRotation;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactRotationDto;
import ro.ubb.abc2024.utils.converter.Converter;

@Component
public class ArtifactRotationDtoConverter implements Converter<ArtifactRotation, ArtifactRotationDto> {
    @Override
    public ArtifactRotation createFromDto(ArtifactRotationDto dto) {
        return ArtifactRotation.builder()
                .pitch(dto.pitch())
                .yaw(dto.yaw())
                .roll(dto.roll())
                .build();
    }

    @Override
    public ArtifactRotationDto createFromEntity(ArtifactRotation entity) {
        return new ArtifactRotationDto(
                entity.getPitch(),
                entity.getYaw(),
                entity.getRoll()
        );
    }
}
