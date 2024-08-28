package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar2Dto;

@Mapper(componentModel = "spring")
public interface PermanentMandibleMolar2Mapper extends PermanentMolarMapper {

    PermanentMandibleMolar2Dto toDto(PermanentMandibleMolar2 entity);

    PermanentMandibleMolar2 toEntity(PermanentMandibleMolar2Dto dto);

}
