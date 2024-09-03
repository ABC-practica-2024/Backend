package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Parietal;
import ro.ubb.abc2024.biology.dto.Cranial.ParietalDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ParietalMapper {
    ParietalDto toDto(Parietal parietal);

    Parietal toEntity(ParietalDto parietalDto);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ParietalDto source, @MappingTarget Parietal target);
}
