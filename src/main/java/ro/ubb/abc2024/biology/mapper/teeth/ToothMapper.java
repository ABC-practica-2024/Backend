package ro.ubb.abc2024.biology.mapper.teeth;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.Tooth;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;
import ro.ubb.abc2024.biology.mapper.BioLabMapper;

@Mapper(componentModel = "spring")
public interface ToothMapper extends BioLabMapper {

    ToothDto toDto(Tooth entity);

    Tooth toEntity(ToothDto dto);
}

