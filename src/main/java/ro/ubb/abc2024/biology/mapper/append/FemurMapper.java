package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.Femur;
import ro.ubb.abc2024.biology.dto.appendicular.FemurDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FemurMapper {
    FemurDto toDto(Femur entity);

    Femur toEntity(FemurDto dto);

    Femur updateEntityFromDto(FemurDto dto, @MappingTarget Femur entity);

}
