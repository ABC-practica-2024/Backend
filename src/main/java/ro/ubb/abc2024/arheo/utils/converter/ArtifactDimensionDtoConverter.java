package ro.ubb.abc2024.arheo.utils.converter;

import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.artifact.ArtifactDimension;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactDimensionDto;
import ro.ubb.abc2024.utils.converter.Converter;

@Component
public class ArtifactDimensionDtoConverter implements Converter<ArtifactDimension, ArtifactDimensionDto> {
    @Override
    public ArtifactDimension createFromDto(ArtifactDimensionDto dto) {
        return ArtifactDimension.builder()
                .length(dto.length())
                .width(dto.width())
                .height(dto.height())
                .build();
    }

    @Override
    public ArtifactDimensionDto createFromEntity(ArtifactDimension entity) {
        return new ArtifactDimensionDto(
                entity.getLength(),
                entity.getWidth(),
                entity.getHeight()
        );
    }
}
