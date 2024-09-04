package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor2Dto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaIncisor2Mapper {

    PermanentMaxillaIncisor2Dto toDto(PermanentMaxillaIncisor2 entity);

    PermanentMaxillaIncisor2 toEntity(PermanentMaxillaIncisor2Dto dto);

    void updateEntityFromDto(PermanentMaxillaIncisor2Dto dto, @MappingTarget PermanentMaxillaIncisor2 entity);

}
