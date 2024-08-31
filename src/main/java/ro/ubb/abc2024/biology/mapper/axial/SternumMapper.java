package ro.ubb.abc2024.biology.mapper.axial;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.axial.Sternum;
import ro.ubb.abc2024.biology.dto.axial.SternumDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SternumMapper {

    SternumDto toDto(Sternum entity);

    Sternum toEntity(SternumDto dto);

    void updateEntityFromDto(SternumDto dto, @MappingTarget Sternum entity);

}
