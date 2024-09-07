package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.Nasal;
import ro.ubb.abc2024.biology.domain.Cranial.NonmetricTraitsMidElement;
import ro.ubb.abc2024.biology.dto.Cranial.NasalDto;
import ro.ubb.abc2024.biology.dto.Cranial.NonmetricTraitsMidElementDto;

@Mapper(componentModel = "spring")
public interface NonmetricTraitsMidMapper {

    NonmetricTraitsMidElementDto toDto(NonmetricTraitsMidElement nonmetricTraitsMidElement);

    NonmetricTraitsMidElement toEntity(NonmetricTraitsMidElementDto nonmetricTraitsMidElementDto);

    void updateEntityFromDto(NonmetricTraitsMidElementDto source, @MappingTarget NonmetricTraitsMidElement target);
}
