package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.Clavicle;
import ro.ubb.abc2024.biology.dto.appendicular.ClavicleDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClavicleMapper {
    ClavicleDto toDto(Clavicle entity);

    Clavicle toEntity(ClavicleDto dto);

    Clavicle updateEntityFromDto(ClavicleDto dto, @MappingTarget Clavicle entity);

}
