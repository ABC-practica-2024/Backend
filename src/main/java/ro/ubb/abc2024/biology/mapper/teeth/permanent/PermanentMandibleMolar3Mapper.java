package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar3Dto;

@Mapper(componentModel = "spring")
public interface PermanentMandibleMolar3Mapper {

    PermanentMandibleMolar3Dto toDto(PermanentMandibleMolar3 entity);

    PermanentMandibleMolar3 toEntity(PermanentMandibleMolar3Dto dto);

    void updateEntityFromDto(PermanentMandibleMolar3Dto dto, @MappingTarget PermanentMandibleMolar3 entity);

}
