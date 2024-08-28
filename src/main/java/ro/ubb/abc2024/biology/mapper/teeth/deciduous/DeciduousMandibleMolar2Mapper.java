package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface DeciduousMandibleMolar2Mapper extends ToothMapper {

    DeciduousMandibleMolar2Dto toDto(DeciduousMandibleMolar2 entity);

    DeciduousMandibleMolar2 toEntity(DeciduousMandibleMolar2Dto dto);
}
