package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor2Dto;

@Mapper(componentModel = "spring")
public interface DeciduousMandibleIncisor2Mapper extends DeciduousIncisorMapper {

    DeciduousMandibleIncisor2Dto toDto(DeciduousMandibleIncisor2 entity);

    DeciduousMandibleIncisor2 toEntity(DeciduousMandibleIncisor2Dto dto);
}
