package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar1Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DeciduousMandibleMolar1Mapper {

    DeciduousMandibleMolar1Dto toDto(DeciduousMandibleMolar1 entity);

    DeciduousMandibleMolar1 toEntity(DeciduousMandibleMolar1Dto dto);

    void updateEntityFromDto(DeciduousMandibleMolar1Dto dto, @MappingTarget DeciduousMandibleMolar1 entity);

}
