package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.Ischium;
import ro.ubb.abc2024.biology.dto.appendicular.IschiumDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IschiumMapper {
    IschiumDto toDto(Ischium entity);

    Ischium toEntity(IschiumDto dto);

    Ischium updateEntityFromDto(IschiumDto dto, @MappingTarget Ischium entity);

}
