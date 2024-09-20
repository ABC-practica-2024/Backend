package ro.ubb.abc2024.arheo.utils.dto;

import ro.ubb.abc2024.arheo.domain.section.SectionStatus;

import java.time.LocalDateTime;
import java.util.List;

public record SectionDto(
        long id,
        String name,
        GeographicPointDto southWest,
        GeographicPointDto northWest,
        GeographicPointDto northEast,
        GeographicPointDto southEast,
        SectionDimensionsDto dimensions,
        SectionStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        long siteId,
        List<Long> artifactIds
){
}
