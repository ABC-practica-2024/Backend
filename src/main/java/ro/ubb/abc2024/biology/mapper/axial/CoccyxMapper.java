package ro.ubb.abc2024.biology.mapper.axial;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.axial.Coccyx;
import ro.ubb.abc2024.biology.dto.axial.CoccyxDto;

@Mapper(componentModel = "spring")
public interface CoccyxMapper {

    CoccyxDto toDto(Coccyx entity);

    Coccyx toEntity(CoccyxDto dto);

    void updateEntityFromDto(CoccyxDto dto, @MappingTarget Coccyx entity);

}
