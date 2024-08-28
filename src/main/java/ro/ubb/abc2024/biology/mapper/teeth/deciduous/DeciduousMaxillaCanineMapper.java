package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface DeciduousMaxillaCanineMapper extends ToothMapper {

    DeciduousMaxillaCanineDto toDto(DeciduousMaxillaCanine entity);

    DeciduousMaxillaCanine toEntity(DeciduousMaxillaCanineDto dto);
}
