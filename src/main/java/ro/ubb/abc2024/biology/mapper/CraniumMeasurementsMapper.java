package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Cranial.CraniumMeasurements;
import ro.ubb.abc2024.biology.domain.Cranial.Ethmoid;
import ro.ubb.abc2024.biology.dto.Cranial.CraniumMeasurementsDto;
import ro.ubb.abc2024.biology.dto.Cranial.EthmoidDto;

@Mapper(componentModel = "spring")
public interface CraniumMeasurementsMapper{
    CraniumMeasurementsDto toDto(CraniumMeasurements cranium);

    CraniumMeasurements toEntity(CraniumMeasurementsDto craniumDto);

    void updateEntityFromDto(CraniumMeasurementsDto source, @MappingTarget CraniumMeasurements target);
}
