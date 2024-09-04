package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaCanineDto;

@Mapper(componentModel = "spring")
public interface PermanentMaxillaCanineMapper {

    PermanentMaxillaCanineDto toDto(PermanentMaxillaCanine entity);

    PermanentMaxillaCanine toEntity(PermanentMaxillaCanineDto dto);

    void updateEntityFromDto(PermanentMaxillaCanineDto dto, @MappingTarget PermanentMaxillaCanine entity);

}
