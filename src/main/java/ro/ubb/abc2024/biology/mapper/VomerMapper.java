package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Vomer;
import ro.ubb.abc2024.biology.dto.Cranial.VomerDto;


@Mapper(componentModel = "spring")
public interface VomerMapper {
    VomerDto toDto(Vomer vomer);

    Vomer toEntity(VomerDto vomerDto);


    void updateEntityFromDto(VomerDto source, @MappingTarget Vomer target);
}
