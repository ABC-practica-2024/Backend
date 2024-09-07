package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.Cranial.SutureClosure;
import ro.ubb.abc2024.biology.dto.Cranial.SutureClosureDto;
@Mapper(componentModel = "spring")
public interface SutureClosureMapper {
    SutureClosureDto toDto(SutureClosure sutureClosure);

    SutureClosure toEntity(SutureClosureDto sutureClosureDto);

    void updateEntityFromDto(SutureClosureDto source, @MappingTarget SutureClosure target);
}
