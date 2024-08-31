package ro.ubb.abc2024.biology.mapper.axial;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.axial.Ribs;
import ro.ubb.abc2024.biology.dto.axial.RibsDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RibsMapper {

    RibsDto toDto(Ribs entity);

    Ribs toEntity(RibsDto dto);

    void updateEntityFromDto(RibsDto dto, @MappingTarget Ribs entity);

}
