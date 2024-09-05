package ro.ubb.abc2024.biology.mapper.teeth;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.Tooth;
import ro.ubb.abc2024.biology.dto.ToothDto;

@Mapper(componentModel = "spring")
public interface ToothMapper {

    ToothDto toDto(Tooth entity);

    Tooth toEntity(ToothDto dto);

    Tooth updateEntityFromDto(ToothDto dto, @MappingTarget Tooth entity);
}
