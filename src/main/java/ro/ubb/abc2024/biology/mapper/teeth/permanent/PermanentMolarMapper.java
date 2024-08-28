package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMolar;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMolarDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface PermanentMolarMapper extends ToothMapper {

    PermanentMolarDto toDto(PermanentMolar entity);

    PermanentMolar toEntity(PermanentMolarDto dto);

}
