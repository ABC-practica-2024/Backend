package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface DeciduousMaxillaMolar2Mapper extends ToothMapper {

    DeciduousMaxillaMolar2Dto toDto(DeciduousMaxillaMolar2 entity);

    DeciduousMaxillaMolar2 toEntity(DeciduousMaxillaMolar2Dto dto);
}
