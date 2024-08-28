package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousIncisor;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousIncisorDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface DeciduousIncisorMapper extends ToothMapper {

    DeciduousIncisorDto toDto(DeciduousIncisor entity);

    DeciduousIncisor toEntity(DeciduousIncisorDto dto);

}
