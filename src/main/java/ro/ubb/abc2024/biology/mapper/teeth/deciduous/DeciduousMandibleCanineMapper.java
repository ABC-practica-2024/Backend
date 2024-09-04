package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleCanineDto;

@Mapper(componentModel = "spring")
public interface DeciduousMandibleCanineMapper {

    DeciduousMandibleCanineDto toDto(DeciduousMandibleCanine entity);

    DeciduousMandibleCanine toEntity(DeciduousMandibleCanineDto dto);

    void updateEntityFromDto(DeciduousMandibleCanineDto dto, @MappingTarget DeciduousMandibleCanine entity);

}
