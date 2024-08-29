package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousIncisor;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousIncisorDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DeciduousIncisorMapper {

    DeciduousIncisorDto toDto(DeciduousIncisor entity);

    DeciduousIncisor toEntity(DeciduousIncisorDto dto);

    void updateEntityFromDto(DeciduousIncisorDto dto, @MappingTarget DeciduousIncisor entity);

}
