package ro.ubb.abc2024.biology.mapper.teeth.deciduous;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface DeciduousMandibleMolar1Mapper extends ToothMapper {

    DeciduousMandibleMolar1Dto toDto(DeciduousMandibleMolar1 entity);

    DeciduousMandibleMolar1 toEntity(DeciduousMandibleMolar1Dto dto);
}
