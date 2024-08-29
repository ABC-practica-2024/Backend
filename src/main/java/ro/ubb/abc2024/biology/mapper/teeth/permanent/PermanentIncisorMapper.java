package ro.ubb.abc2024.biology.mapper.teeth.permanent;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentIncisor;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentIncisorDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermanentIncisorMapper {

    PermanentIncisorDto toDto(PermanentIncisor entity);

    PermanentIncisor toEntity(PermanentIncisorDto dto);

    void updateEntityFromDto(PermanentIncisorDto dto, @MappingTarget PermanentIncisor entity);

}
