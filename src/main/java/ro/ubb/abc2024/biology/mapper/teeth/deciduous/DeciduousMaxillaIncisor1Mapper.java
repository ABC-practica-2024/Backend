package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor1Dto;

@Mapper(componentModel = "spring")
public interface DeciduousMaxillaIncisor1Mapper extends DeciduousIncisorMapper {

    DeciduousMaxillaIncisor1Dto toDto(DeciduousMaxillaIncisor1 entity);

    DeciduousMaxillaIncisor1 toEntity(DeciduousMaxillaIncisor1Dto dto);
}
