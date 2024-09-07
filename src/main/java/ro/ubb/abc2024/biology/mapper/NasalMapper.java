package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Nasal;
import ro.ubb.abc2024.biology.dto.Cranial.NasalDto;

@Mapper(componentModel = "spring")
public interface NasalMapper {

    NasalDto toDto(Nasal nasal);

    Nasal toEntity(NasalDto nasalDto);


    void updateEntityFromDto(NasalDto source, @MappingTarget Nasal target);
}
