package ro.ubb.abc2024.biology.mapper;

import  org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.NonmetricTraitsMidElement;
import ro.ubb.abc2024.biology.domain.Cranial.NonmetricTraitsSideElement;
import ro.ubb.abc2024.biology.dto.Cranial.NonmetricTraitsMidElementDto;
import ro.ubb.abc2024.biology.dto.Cranial.NonmetricTraitsSideElementDto;

@Mapper(componentModel = "spring")
public interface NonmetricTraitsSideMapper {

    NonmetricTraitsSideElementDto toDto(NonmetricTraitsSideElement nonmetricTraitsSideElement);

    NonmetricTraitsSideElement toEntity(NonmetricTraitsSideElementDto nonmetricTraitsSideElementDto);

    void updateEntityFromDto(NonmetricTraitsSideElementDto source, @MappingTarget NonmetricTraitsSideElement target);
}
