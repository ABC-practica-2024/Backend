package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor2Dto;

@Mapper(componentModel = "spring")
public interface DeciduousMaxillaIncisor2Mapper extends DeciduousIncisorMapper {

    DeciduousMaxillaIncisor2Dto toDto(DeciduousMaxillaIncisor2 entity);

    DeciduousMaxillaIncisor2 toEntity(DeciduousMaxillaIncisor2Dto dto);
}
