package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;

import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.dto.teeth.BoneDto;


@Mapper(componentModel = "spring")
public interface BoneMapper extends BioLabMapper {

    BoneDto toDto(Bone entity);

    Bone toEntity(BoneDto dto);

}
