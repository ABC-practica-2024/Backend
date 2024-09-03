package ro.ubb.abc2024.biology.mapper;

import  org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.NonmetricTraitsSideElement;
import ro.ubb.abc2024.biology.dto.Cranial.NonmetricTraitsSideElementDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NonmetricTraitsSideMapper {

    NonmetricTraitsSideElementDto toDto(NonmetricTraitsSideElement nonmetricTraitsSideElement);

    NonmetricTraitsSideElement toEntity(NonmetricTraitsSideElementDto nonmetricTraitsSideElementDto);
}
