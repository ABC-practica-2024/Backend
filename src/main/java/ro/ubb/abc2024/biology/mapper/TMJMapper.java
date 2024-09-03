package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.TMJ;
import ro.ubb.abc2024.biology.dto.Cranial.TMJDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TMJMapper {
    TMJDto toDto(TMJ tmj);

    TMJ toEntity(TMJDto tmjDto);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(TMJDto source, @MappingTarget TMJ target);
}
