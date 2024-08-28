package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor1Dto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaIncisor1Mapper extends PermanentIncisorMapper {

    PermanentMaxillaIncisor1Dto toDto(PermanentMaxillaIncisor1 entity);

    PermanentMaxillaIncisor1 toEntity(PermanentMaxillaIncisor1Dto dto);

}
