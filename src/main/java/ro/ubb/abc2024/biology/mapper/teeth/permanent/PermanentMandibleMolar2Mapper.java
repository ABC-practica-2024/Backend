package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar2Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentMandibleMolar2Mapper {

    PermanentMandibleMolar2Dto toDto(PermanentMandibleMolar2 entity);

    PermanentMandibleMolar2 toEntity(PermanentMandibleMolar2Dto dto);

    void updateEntityFromDto(PermanentMandibleMolar2Dto dto, @MappingTarget PermanentMandibleMolar2 entity);

}
