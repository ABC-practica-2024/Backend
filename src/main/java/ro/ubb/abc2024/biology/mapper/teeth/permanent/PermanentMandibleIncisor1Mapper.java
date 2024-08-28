package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor1Dto;

@Mapper(componentModel = "spring")
public interface PermanentMandibleIncisor1Mapper extends PermanentIncisorMapper {

    PermanentMandibleIncisor1Dto toDto(PermanentMandibleIncisor1 entity);

    PermanentMandibleIncisor1 toEntity(PermanentMandibleIncisor1Dto dto);

}
