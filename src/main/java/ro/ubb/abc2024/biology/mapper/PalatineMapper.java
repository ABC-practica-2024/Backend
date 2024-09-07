package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Palatine;
import ro.ubb.abc2024.biology.dto.Cranial.PalatineDto;


@Mapper(componentModel = "spring")
public interface PalatineMapper {
    PalatineDto toDto(Palatine palatines);

    Palatine toEntity(PalatineDto palatinesDto);


    void updateEntityFromDto(PalatineDto source, @MappingTarget Palatine target);
}
