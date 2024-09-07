package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Thyroid;
import ro.ubb.abc2024.biology.dto.Cranial.ThyroidDto;


@Mapper(componentModel = "spring")
public interface ThyroidMapper {
    ThyroidDto toDto(Thyroid ossicles);

    Thyroid toEntity(ThyroidDto ossiclesDto);


    void updateEntityFromDto(ThyroidDto source, @MappingTarget Thyroid target);
}
