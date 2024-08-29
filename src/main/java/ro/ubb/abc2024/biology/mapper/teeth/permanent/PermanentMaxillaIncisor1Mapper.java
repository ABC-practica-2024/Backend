package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor1Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentMaxillaIncisor1Mapper {

    PermanentMaxillaIncisor1Dto toDto(PermanentMaxillaIncisor1 entity);

    PermanentMaxillaIncisor1 toEntity(PermanentMaxillaIncisor1Dto dto);

    void updateEntityFromDto(PermanentMaxillaIncisor1Dto dto, @MappingTarget PermanentMaxillaIncisor1 entity);

}
