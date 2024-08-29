package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar1Dto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentMaxillaPremolar1Mapper {

    PermanentMaxillaPremolar1Dto toDto(PermanentMaxillaPremolar1 entity);

    PermanentMaxillaPremolar1 toEntity(PermanentMaxillaPremolar1Dto dto);

    void updateEntityFromDto(PermanentMaxillaPremolar1Dto dto, @MappingTarget PermanentMaxillaPremolar1 entity);

}
