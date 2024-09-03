package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.NonmetricTraitsMidElement;
import ro.ubb.abc2024.biology.dto.Cranial.NonmetricTraitsMidElementDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NonmetricTraitsMidMapper {

    NonmetricTraitsMidElementDto toDto(NonmetricTraitsMidElement nonmetricTraitsMidElement);

    NonmetricTraitsMidElement toEntity(NonmetricTraitsMidElementDto nonmetricTraitsMidElementDto);
}
