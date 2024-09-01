package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.InnominateOsCoxaHipBone;
import ro.ubb.abc2024.biology.dto.appendicular.InnominateOsCoxaHipBoneDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InnominateOsCoxaHipBoneMapper {

    InnominateOsCoxaHipBoneDto toDto(InnominateOsCoxaHipBone entity);

    InnominateOsCoxaHipBone toEntity(InnominateOsCoxaHipBoneDto dto);

    InnominateOsCoxaHipBone updateEntityFromDto(InnominateOsCoxaHipBoneDto dto, @MappingTarget InnominateOsCoxaHipBone entity);
}
