package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar2Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DeciduousMaxillaMolar2Mapper {

    DeciduousMaxillaMolar2Dto toDto(DeciduousMaxillaMolar2 entity);

    DeciduousMaxillaMolar2 toEntity(DeciduousMaxillaMolar2Dto dto);

    void updateEntityFromDto(DeciduousMaxillaMolar2Dto dto, @MappingTarget DeciduousMaxillaMolar2 entity);

}
