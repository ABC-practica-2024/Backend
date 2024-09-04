package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Fibula;
import ro.ubb.abc2024.biology.dto.appendicular.FibulaDto;

@Mapper(componentModel = "spring")
public interface FibulaMapper {
    FibulaDto toDto(Fibula entity);

    Fibula toEntity(FibulaDto dto);

    Fibula updateEntityFromDto(FibulaDto dto, @MappingTarget Fibula entity);

}
