package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.CraniumMeasurements;
import ro.ubb.abc2024.biology.dto.Cranial.CraniumMeasurementsDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CraniumMeasurementsMapper{
    CraniumMeasurementsDto toDto(CraniumMeasurements cranium);

    CraniumMeasurements toEntity(CraniumMeasurementsDto craniumDto);

}
