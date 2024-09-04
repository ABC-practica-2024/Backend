package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar1Dto;

@Mapper(componentModel = "spring")
public interface DeciduousMaxillaMolar1Mapper {

    DeciduousMaxillaMolar1Dto toDto(DeciduousMaxillaMolar1 entity);

    DeciduousMaxillaMolar1 toEntity(DeciduousMaxillaMolar1Dto dto);

    void updateEntityFromDto(DeciduousMaxillaMolar1Dto dto, @MappingTarget DeciduousMaxillaMolar1 entity);

}
