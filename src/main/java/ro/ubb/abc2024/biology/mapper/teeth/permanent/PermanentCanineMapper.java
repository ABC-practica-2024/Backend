package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface PermanentCanineMapper extends ToothMapper {

    PermanentCanineDto toDto(PermanentCanine entity);

    PermanentCanine toEntity(PermanentCanineDto dto);

}
