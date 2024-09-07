package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.InferiorNasalConcha;
import ro.ubb.abc2024.biology.dto.Cranial.InferiorNasalConchaDto;

@Mapper(componentModel = "spring")
public interface InferiorNasalConchaMapper {

    InferiorNasalConchaDto toDto(InferiorNasalConcha inferiorNasalConcha);

    InferiorNasalConcha toEntity(InferiorNasalConchaDto inferiorNasalConchaDto);


    void updateEntityFromDto(InferiorNasalConchaDto source, @MappingTarget InferiorNasalConcha target);
}
