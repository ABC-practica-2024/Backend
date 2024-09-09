package ro.ubb.abc2024.arheo.utils.dto;

import lombok.Getter;
import ro.ubb.abc2024.arheo.domain.section.SectionDimensions;

public record SectionDimensionsDto(
        double length,
        double width,
        double depth
){

}