package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.Humerus;
import ro.ubb.abc2024.biology.dto.appendicular.HumerusDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HumerusMapper {
    HumerusDto toDto(Humerus entity);

    Humerus toEntity(HumerusDto dto);

    Humerus updateEntityFromDto(HumerusDto dto, @MappingTarget Humerus entity);

}
