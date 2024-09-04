package ro.ubb.abc2024.biology.mapper.axial;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.axial.Vertebrae;
import ro.ubb.abc2024.biology.dto.axial.VertebraeDto;

@Mapper(componentModel = "spring")
public interface VertebraeMapper {

    VertebraeDto toDto(Vertebrae entity);

    Vertebrae toEntity(VertebraeDto dto);

    void updateEntityFromDto(VertebraeDto dto, @MappingTarget Vertebrae entity);

}
