package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleCanineDto;

@Mapper(componentModel = "spring")
public interface PermanentMandibleCanineMapper extends PermanentCanineMapper {

    PermanentMandibleCanineDto toDto(PermanentMandibleCanine entity);

    PermanentMandibleCanine toEntity(PermanentMandibleCanineDto dto);

}
