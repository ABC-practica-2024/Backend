package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Hyoid;
import ro.ubb.abc2024.biology.dto.Cranial.HyoidDto;

@Mapper(componentModel = "spring")
public interface HyoidMapper {

    HyoidDto toDto(Hyoid hyoid);

    Hyoid toEntity(HyoidDto hyoidDto);


    void updateEntityFromDto(HyoidDto source, @MappingTarget Hyoid target);
}
