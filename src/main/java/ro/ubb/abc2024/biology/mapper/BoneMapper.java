package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.dto.BoneDto;

@Mapper(componentModel = "spring")
public interface BoneMapper {

    BoneDto toDto(Bone entity);

    Bone toEntity(BoneDto dto);

    Bone updateEntityFromDto(BoneDto dto, @MappingTarget Bone entity);

}