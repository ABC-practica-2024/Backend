package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Sphenoid;
import ro.ubb.abc2024.biology.dto.Cranial.SphenoidDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SphenoidMapper {
    SphenoidDto toDto(Sphenoid sphenoid);

    Sphenoid toEntity(SphenoidDto sphenoidDto);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(SphenoidDto source, @MappingTarget Sphenoid target);
}
