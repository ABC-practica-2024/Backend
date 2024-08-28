package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface DeciduousMandibleCanineMapper extends ToothMapper {

    DeciduousMandibleCanineDto toDto(DeciduousMandibleCanine entity);

    DeciduousMandibleCanine toEntity(DeciduousMandibleCanineDto dto);
}
