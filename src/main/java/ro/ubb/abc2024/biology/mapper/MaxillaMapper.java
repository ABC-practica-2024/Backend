package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Maxilla;
import ro.ubb.abc2024.biology.dto.Cranial.MaxillaDto;

@Mapper(componentModel = "spring")
public interface MaxillaMapper {

    MaxillaDto toDto(Maxilla maxilla);

    Maxilla toEntity(MaxillaDto maxillaDto);


    void updateEntityFromDto(MaxillaDto source, @MappingTarget Maxilla target);
}
