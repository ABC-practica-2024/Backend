package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Ossicles;
import ro.ubb.abc2024.biology.dto.Cranial.OssiclesDto;


@Mapper(componentModel = "spring")
public interface OssiclesMapper {
    OssiclesDto toDto(Ossicles ossicles);

    Ossicles toEntity(OssiclesDto ossiclesDto);


    void updateEntityFromDto(OssiclesDto source, @MappingTarget Ossicles target);
}
