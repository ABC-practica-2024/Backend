package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Occipital;
import ro.ubb.abc2024.biology.dto.Cranial.OccipitalDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OccipitalMapper {

    OccipitalDto toDto(Occipital occipital);

    Occipital toEntity(OccipitalDto occipitalDto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(OccipitalDto source, @MappingTarget Occipital target);
}
