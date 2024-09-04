package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar2Dto;

@Mapper(componentModel = "spring")
public interface DeciduousMandibleMolar2Mapper {

    DeciduousMandibleMolar2Dto toDto(DeciduousMandibleMolar2 entity);

    DeciduousMandibleMolar2 toEntity(DeciduousMandibleMolar2Dto dto);

    void updateEntityFromDto(DeciduousMandibleMolar2Dto dto, @MappingTarget DeciduousMandibleMolar2 entity);

}
