package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor2Dto;

@Mapper(componentModel = "spring")
public interface DeciduousMaxillaIncisor2Mapper {

    DeciduousMaxillaIncisor2Dto toDto(DeciduousMaxillaIncisor2 entity);

    DeciduousMaxillaIncisor2 toEntity(DeciduousMaxillaIncisor2Dto dto);

    void updateEntityFromDto(DeciduousMaxillaIncisor2Dto dto, @MappingTarget DeciduousMaxillaIncisor2 entity);

}
