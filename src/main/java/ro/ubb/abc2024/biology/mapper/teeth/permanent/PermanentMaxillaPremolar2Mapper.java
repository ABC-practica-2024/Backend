package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar2Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentMaxillaPremolar2Mapper {

    PermanentMaxillaPremolar2Dto toDto(PermanentMaxillaPremolar2 entity);

    PermanentMaxillaPremolar2 toEntity(PermanentMaxillaPremolar2Dto dto);

    void updateEntityFromDto(PermanentMaxillaPremolar2Dto dto, @MappingTarget PermanentMaxillaPremolar2 entity);

}
