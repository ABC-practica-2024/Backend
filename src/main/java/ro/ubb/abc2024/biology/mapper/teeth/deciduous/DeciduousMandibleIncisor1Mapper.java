package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor1Dto;

@Mapper(componentModel = "spring")
public interface DeciduousMandibleIncisor1Mapper {

    DeciduousMandibleIncisor1Dto toDto(DeciduousMandibleIncisor1 entity);

    DeciduousMandibleIncisor1 toEntity(DeciduousMandibleIncisor1Dto dto);

    void updateEntityFromDto(DeciduousMandibleIncisor1Dto dto, @MappingTarget DeciduousMandibleIncisor1 entity);

}
