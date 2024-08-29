package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor1Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentMandibleIncisor1Mapper {

    PermanentMandibleIncisor1Dto toDto(PermanentMandibleIncisor1 entity);

    PermanentMandibleIncisor1 toEntity(PermanentMandibleIncisor1Dto dto);

    void updateEntityFromDto(PermanentMandibleIncisor1Dto dto, @MappingTarget PermanentMandibleIncisor1 entity);

}
