package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Ilium;
import ro.ubb.abc2024.biology.dto.appendicular.IliumDto;

@Mapper(componentModel = "spring")
public interface IliumMapper {
    IliumDto toDto(Ilium entity);

    Ilium toEntity(IliumDto dto);

    Ilium updateEntityFromDto(IliumDto dto, @MappingTarget Ilium entity);

}
