package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Ethmoid;
import ro.ubb.abc2024.biology.dto.Cranial.EthmoidDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EthmoidMapper {

    EthmoidDto toDto(Ethmoid ethmoid);

    Ethmoid toEntity(EthmoidDto ethmoidDto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(EthmoidDto source, @MappingTarget Ethmoid target);
}
