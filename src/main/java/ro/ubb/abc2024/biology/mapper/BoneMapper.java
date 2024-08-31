package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.dto.BoneDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BoneMapper {

    BoneDto toDto(Bone entity);

    Bone toEntity(BoneDto dto);

    Bone updateEntityFromDto(BoneDto dto, @MappingTarget Bone entity);

}
