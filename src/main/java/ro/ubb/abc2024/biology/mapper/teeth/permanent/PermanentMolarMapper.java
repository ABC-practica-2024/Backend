package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMolar;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMolarDto;

@Mapper(componentModel = "spring")
public interface PermanentMolarMapper {

    PermanentMolarDto toDto(PermanentMolar entity);

    PermanentMolar toEntity(PermanentMolarDto dto);

    void updateEntityFromDto(PermanentMolarDto dto, @MappingTarget PermanentMolar entity);

}
