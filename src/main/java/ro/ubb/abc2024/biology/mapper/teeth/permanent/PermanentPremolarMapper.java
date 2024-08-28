package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentPremolar;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentPremolarDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

@Mapper(componentModel = "spring")
public interface PermanentPremolarMapper extends ToothMapper {

    PermanentPremolarDto toDto(PermanentPremolar entity);

    PermanentPremolar toEntity(PermanentPremolarDto dto);

}
