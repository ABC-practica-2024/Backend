package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar1Dto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaPremolar1Mapper extends PermanentPremolarMapper {

    PermanentMaxillaPremolar1Dto toDto(PermanentMaxillaPremolar1 entity);

    PermanentMaxillaPremolar1 toEntity(PermanentMaxillaPremolar1Dto dto);

}
