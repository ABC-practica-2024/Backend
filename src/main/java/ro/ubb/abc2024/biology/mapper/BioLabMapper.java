package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.BioLab;
import ro.ubb.abc2024.biology.dto.teeth.BioLabDto;

@Mapper(componentModel = "spring")
public interface BioLabMapper {

    BioLabDto toDto(BioLab entity);

    BioLab toEntity(BioLabDto dto);

}
