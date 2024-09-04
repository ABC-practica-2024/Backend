package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar2Dto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaMolar2Mapper {

    PermanentMaxillaMolar2Dto toDto(PermanentMaxillaMolar2 entity);

    PermanentMaxillaMolar2 toEntity(PermanentMaxillaMolar2Dto dto);

    void updateEntityFromDto(PermanentMaxillaMolar2Dto dto, @MappingTarget PermanentMaxillaMolar2 entity);

}
