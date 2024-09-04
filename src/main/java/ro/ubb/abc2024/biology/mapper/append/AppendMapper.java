package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Append;
import ro.ubb.abc2024.biology.dto.appendicular.AppendDto;

@Mapper(componentModel = "spring")
public interface AppendMapper {
    AppendDto toDto(Append entity);

    Append toEntity(AppendDto dto);

    Append updateEntityFromDto(AppendDto dto, @MappingTarget Append entity);

}
