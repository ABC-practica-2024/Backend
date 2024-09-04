package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Scapula;
import ro.ubb.abc2024.biology.dto.appendicular.ScapulaDto;

@Mapper(componentModel = "spring")
public interface ScapulaMapper {
    ScapulaDto toDto(Scapula entity);

    Scapula toEntity(ScapulaDto dto);

    Scapula updateEntityFromDto(ScapulaDto dto, @MappingTarget Scapula entity);

}
