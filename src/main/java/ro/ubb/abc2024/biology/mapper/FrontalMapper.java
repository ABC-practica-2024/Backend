package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Frontal;
import ro.ubb.abc2024.biology.dto.Cranial.FrontalDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FrontalMapper {

    FrontalDto toDto(Frontal frontal);

    Frontal toEntity(FrontalDto frontalDto);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(FrontalDto source, @MappingTarget Frontal target);
}
