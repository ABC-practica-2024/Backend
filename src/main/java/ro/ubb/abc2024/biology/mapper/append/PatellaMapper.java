package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Patella;
import ro.ubb.abc2024.biology.dto.appendicular.PatellaDto;

@Mapper(componentModel = "spring")
public interface PatellaMapper {
    PatellaDto toDto(Patella entity);

    Patella toEntity(PatellaDto dto);

    Patella updateEntityFromDto(PatellaDto dto, @MappingTarget Patella entity);

}
