package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Lacrimal;
import ro.ubb.abc2024.biology.dto.Cranial.LacrimalDto;

@Mapper(componentModel = "spring")
public interface LacrimalMapper {

    LacrimalDto toDto(Lacrimal lacrimal);

    Lacrimal toEntity(LacrimalDto lacrimalDto);


    void updateEntityFromDto(LacrimalDto source, @MappingTarget Lacrimal target);
}
