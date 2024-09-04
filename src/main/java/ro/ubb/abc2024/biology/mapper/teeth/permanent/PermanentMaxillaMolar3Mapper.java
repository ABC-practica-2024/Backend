package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar3Dto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaMolar3Mapper {

    PermanentMaxillaMolar3Dto toDto(PermanentMaxillaMolar3 entity);

    PermanentMaxillaMolar3 toEntity(PermanentMaxillaMolar3Dto dto);

    void updateEntityFromDto(PermanentMaxillaMolar3Dto dto, @MappingTarget PermanentMaxillaMolar3 entity);

}
