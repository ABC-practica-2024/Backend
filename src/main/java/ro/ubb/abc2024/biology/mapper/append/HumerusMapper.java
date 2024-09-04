package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Humerus;
import ro.ubb.abc2024.biology.dto.appendicular.HumerusDto;

@Mapper(componentModel = "spring")
public interface HumerusMapper {
    HumerusDto toDto(Humerus entity);

    Humerus toEntity(HumerusDto dto);

    Humerus updateEntityFromDto(HumerusDto dto, @MappingTarget Humerus entity);

}
