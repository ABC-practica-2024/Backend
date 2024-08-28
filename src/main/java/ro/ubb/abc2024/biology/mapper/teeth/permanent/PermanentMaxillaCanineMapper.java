package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaCanineDto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaCanineMapper extends PermanentCanineMapper {

    PermanentMaxillaCanineDto toDto(PermanentMaxillaCanine entity);

    PermanentMaxillaCanine toEntity(PermanentMaxillaCanineDto dto);

}
