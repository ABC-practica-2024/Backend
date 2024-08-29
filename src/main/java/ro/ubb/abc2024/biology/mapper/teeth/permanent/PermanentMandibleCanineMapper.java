package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleCanineDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentMandibleCanineMapper {

    PermanentMandibleCanineDto toDto(PermanentMandibleCanine entity);

    PermanentMandibleCanine toEntity(PermanentMandibleCanineDto dto);

    void updateEntityFromDto(PermanentMandibleCanineDto dto, @MappingTarget PermanentMandibleCanine entity);

}
