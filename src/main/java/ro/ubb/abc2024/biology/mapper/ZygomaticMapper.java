package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Zygomatic;
import ro.ubb.abc2024.biology.dto.Cranial.ZygomaticDto;


@Mapper(componentModel = "spring")
public interface ZygomaticMapper {
    ZygomaticDto toDto(Zygomatic zygomatic);

    Zygomatic toEntity(ZygomaticDto zygomaticDto);


    void updateEntityFromDto(ZygomaticDto source, @MappingTarget Zygomatic target);
}
