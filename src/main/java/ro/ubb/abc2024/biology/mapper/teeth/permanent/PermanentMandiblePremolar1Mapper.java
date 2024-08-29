package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar1Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentMandiblePremolar1Mapper {

    PermanentMandiblePremolar1Dto toDto(PermanentMandiblePremolar1 entity);

    PermanentMandiblePremolar1 toEntity(PermanentMandiblePremolar1Dto dto);

    void updateEntityFromDto(PermanentMandiblePremolar1Dto dto, @MappingTarget PermanentMandiblePremolar1 entity);

}
