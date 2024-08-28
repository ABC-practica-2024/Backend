package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar1Dto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaMolar1Mapper extends PermanentMolarMapper {

    PermanentMaxillaMolar1Dto toDto(PermanentMaxillaMolar1 entity);

    PermanentMaxillaMolar1 toEntity(PermanentMaxillaMolar1Dto dto);

}
