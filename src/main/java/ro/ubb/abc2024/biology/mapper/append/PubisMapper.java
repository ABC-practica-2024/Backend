package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.Pubis;
import ro.ubb.abc2024.biology.dto.appendicular.PubisDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PubisMapper {
    PubisDto toDto(Pubis entity);

    Pubis toEntity(PubisDto dto);

    Pubis updateEntityFromDto(PubisDto dto, @MappingTarget Pubis entity);

}
