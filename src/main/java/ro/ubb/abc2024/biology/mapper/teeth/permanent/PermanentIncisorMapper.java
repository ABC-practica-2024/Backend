package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentIncisor;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentIncisorDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface PermanentIncisorMapper extends ToothMapper {

    PermanentIncisorDto toDto(PermanentIncisor entity);

    PermanentIncisor toEntity(PermanentIncisorDto dto);
}
