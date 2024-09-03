package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Maxilla;
import ro.ubb.abc2024.biology.dto.Cranial.MaxillaDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MaxillaMapper {

    MaxillaDto toDto(Maxilla maxilla);

    Maxilla toEntity(MaxillaDto maxillaDto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(MaxillaDto source, @MappingTarget Maxilla target);
}
