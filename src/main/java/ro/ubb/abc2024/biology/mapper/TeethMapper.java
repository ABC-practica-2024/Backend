package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.SubclassMapping;
import ro.ubb.abc2024.biology.domain.Teeth;
import ro.ubb.abc2024.biology.domain.teeth.Tooth;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentPremolar;
import ro.ubb.abc2024.biology.dto.TeethDto;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentPremolarDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeethMapper {

    TeethDto toDto(Teeth entity);

    Teeth toEntity(TeethDto dto);

    Teeth updateEntityFromDto(TeethDto dto, @MappingTarget Teeth entity);

}
