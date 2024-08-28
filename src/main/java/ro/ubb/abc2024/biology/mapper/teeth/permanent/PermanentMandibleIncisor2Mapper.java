package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor2Dto;

@Mapper(componentModel = "spring")
public interface PermanentMandibleIncisor2Mapper {

    PermanentMandibleIncisor2Dto toDto(PermanentMandibleIncisor2 entity);

    PermanentMandibleIncisor2 toEntity(PermanentMandibleIncisor2Dto dto);

}
