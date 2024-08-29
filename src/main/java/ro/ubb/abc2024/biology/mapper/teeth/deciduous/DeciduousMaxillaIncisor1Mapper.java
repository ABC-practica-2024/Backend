package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor1Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DeciduousMaxillaIncisor1Mapper {

    DeciduousMaxillaIncisor1Dto toDto(DeciduousMaxillaIncisor1 entity);

    DeciduousMaxillaIncisor1 toEntity(DeciduousMaxillaIncisor1Dto dto);

    void updateEntityFromDto(DeciduousMaxillaIncisor1Dto dto, @MappingTarget DeciduousMaxillaIncisor1 entity);

}
