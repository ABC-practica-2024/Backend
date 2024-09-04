package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar1Dto;

@Mapper(componentModel = "spring")
public interface PermanentMandibleMolar1Mapper {

    PermanentMandibleMolar1Dto toDto(PermanentMandibleMolar1 entity);

    PermanentMandibleMolar1 toEntity(PermanentMandibleMolar1Dto dto);

    void updateEntityFromDto(PermanentMandibleMolar1Dto dto, @MappingTarget PermanentMandibleMolar1 entity);

}
