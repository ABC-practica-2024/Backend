package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.dto.BoneDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoneMapper {
    BoneMapper INSTANCE = Mappers.getMapper(BoneMapper.class);

    BoneDto toDto(Bone bone);

    Bone toEntity(BoneDto boneDto);

}
