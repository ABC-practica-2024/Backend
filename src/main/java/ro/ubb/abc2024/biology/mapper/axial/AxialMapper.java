package ro.ubb.abc2024.biology.mapper.axial;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.axial.Axial;
import ro.ubb.abc2024.biology.dto.axial.AxialDto;

@Mapper(componentModel = "spring")
public interface AxialMapper {

    AxialDto toDto(Axial entity);

    Axial toEntity(AxialDto dto);

    Axial updateEntityFromDto(AxialDto dto, @MappingTarget Axial entity);

}
