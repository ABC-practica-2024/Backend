package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Mandible;
import ro.ubb.abc2024.biology.dto.Cranial.MandibleDto;

@Mapper(componentModel = "spring")
public interface MandibleMapper {

    MandibleDto toDto(Mandible mandible);

    Mandible toEntity(MandibleDto mandibleDto);

    void updateEntityFromDto(MandibleDto source, @MappingTarget Mandible target);
}
