package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentPremolar;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentPremolarDto;

@Mapper(componentModel = "spring")
public interface PermanentPremolarMapper {

    PermanentPremolarDto toDto(PermanentPremolar entity);

    PermanentPremolar toEntity(PermanentPremolarDto dto);

    void updateEntityFromDto(PermanentPremolarDto dto, @MappingTarget PermanentPremolar entity);

}
