package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Temporal;
import ro.ubb.abc2024.biology.dto.Cranial.TemporalDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TemporalMapper {
    TemporalDto toDto(Temporal temporal);

    Temporal toEntity(TemporalDto temporalDto);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(TemporalDto source, @MappingTarget Temporal target);
}
