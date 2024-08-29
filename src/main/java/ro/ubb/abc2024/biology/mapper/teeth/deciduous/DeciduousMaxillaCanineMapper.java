package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaCanineDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DeciduousMaxillaCanineMapper {

    DeciduousMaxillaCanineDto toDto(DeciduousMaxillaCanine entity);

    DeciduousMaxillaCanine toEntity(DeciduousMaxillaCanineDto dto);

    void updateEntityFromDto(DeciduousMaxillaCanineDto dto, @MappingTarget DeciduousMaxillaCanine entity);

}
