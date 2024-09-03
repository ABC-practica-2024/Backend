package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.SutureClosure;
import ro.ubb.abc2024.biology.dto.Cranial.SutureClosureDto;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StureClosureMapper {
    SutureClosureDto toDto(SutureClosure sutureClosure);

    SutureClosure toEntity(SutureClosureDto sutureClosureDto);
}
