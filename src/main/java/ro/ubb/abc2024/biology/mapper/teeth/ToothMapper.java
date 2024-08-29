package ro.ubb.abc2024.biology.mapper.teeth;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.Tooth;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;
import ro.ubb.abc2024.biology.mapper.TeethMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ToothMapper extends TeethMapper {
    ToothDto toDto(Tooth entity);

    Tooth toEntity(ToothDto dto);

    Tooth updateEntityFromDto(ToothDto dto, @MappingTarget Tooth entity);
}
