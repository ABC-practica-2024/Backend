package ro.ubb.abc2024.biology.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Cranial;
import ro.ubb.abc2024.biology.dto.Cranial.CranialDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CranialBoneMapper {

    CranialDto toDto(Cranial cranium);

    Cranial toEntity(CranialDto craniumDto);
}
