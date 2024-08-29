package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar2Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentMandiblePremolar2Mapper {

    PermanentMandiblePremolar2Dto toDto(PermanentMandiblePremolar2 entity);

    PermanentMandiblePremolar2 toEntity(PermanentMandiblePremolar2Dto dto);

    void updateEntityFromDto(PermanentMandiblePremolar2Dto dto, @MappingTarget PermanentMandiblePremolar2 entity);

}
