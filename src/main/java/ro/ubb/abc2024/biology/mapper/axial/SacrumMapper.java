package ro.ubb.abc2024.biology.mapper.axial;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.axial.Sacrum;
import ro.ubb.abc2024.biology.dto.axial.SacrumDto;

@Mapper(componentModel = "spring")
public interface SacrumMapper {

    SacrumDto toDto(Sacrum entity);

    Sacrum toEntity(SacrumDto dto);

    void updateEntityFromDto(SacrumDto dto, @MappingTarget Sacrum entity);

}
