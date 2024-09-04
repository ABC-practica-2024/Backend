package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Radius;
import ro.ubb.abc2024.biology.dto.appendicular.RadiusDto;

@Mapper(componentModel = "spring")
public interface RadiusMapper {
    RadiusDto toDto(Radius entity);

    Radius toEntity(RadiusDto dto);

    Radius updateEntityFromDto(RadiusDto dto, @MappingTarget Radius entity);

}
