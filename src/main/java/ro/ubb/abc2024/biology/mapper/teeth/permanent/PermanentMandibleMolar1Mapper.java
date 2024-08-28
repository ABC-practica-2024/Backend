package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar1Dto;

@Mapper(componentModel = "spring")
public interface PermanentMandibleMolar1Mapper extends PermanentMolarMapper {

    PermanentMandibleMolar1Dto toDto(PermanentMandibleMolar1 entity);

    PermanentMandibleMolar1 toEntity(PermanentMandibleMolar1Dto dto);

}
