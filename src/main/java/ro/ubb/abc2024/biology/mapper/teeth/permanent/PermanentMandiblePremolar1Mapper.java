package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar1Dto;

@Mapper(componentModel = "spring")
public interface PermanentMandiblePremolar1Mapper extends PermanentPremolarMapper {

    PermanentMandiblePremolar1Dto toDto(PermanentMandiblePremolar1 entity);

    PermanentMandiblePremolar1 toEntity(PermanentMandiblePremolar1Dto dto);

}
