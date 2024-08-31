package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.BioLab;
import ro.ubb.abc2024.biology.dto.BioLabDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BioLabMapper {

    BioLabDto toDto(BioLab entity);

    BioLab toEntity(BioLabDto dto);

    BioLab updateEntityFromDto(BioLabDto dto, @MappingTarget BioLab entity);

}