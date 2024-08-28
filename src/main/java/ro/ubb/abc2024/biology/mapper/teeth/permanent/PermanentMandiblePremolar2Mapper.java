package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar2Dto;

@Mapper(componentModel = "spring")
public interface PermanentMandiblePremolar2Mapper extends PermanentPremolarMapper {

    PermanentMandiblePremolar2Dto toDto(PermanentMandiblePremolar2 entity);

    PermanentMandiblePremolar2 toEntity(PermanentMandiblePremolar2Dto dto);

}
