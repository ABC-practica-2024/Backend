package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar2Dto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaPremolar2Mapper extends PermanentPremolarMapper {

    PermanentMaxillaPremolar2Dto toDto(PermanentMaxillaPremolar2 entity);

    PermanentMaxillaPremolar2 toEntity(PermanentMaxillaPremolar2Dto dto);

}
