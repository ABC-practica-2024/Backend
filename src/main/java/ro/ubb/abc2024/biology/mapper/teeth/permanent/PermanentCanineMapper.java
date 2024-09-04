package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentCanineDto;

@Mapper(componentModel = "spring")
public interface PermanentCanineMapper {

    PermanentCanineDto toDto(PermanentCanine entity);

    PermanentCanine toEntity(PermanentCanineDto dto);

    void updateEntityFromDto(PermanentCanineDto dto, @MappingTarget PermanentCanine entity);

}
