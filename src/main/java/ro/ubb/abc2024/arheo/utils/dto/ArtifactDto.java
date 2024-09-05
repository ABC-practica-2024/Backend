package ro.ubb.abc2024.arheo.utils.dto;

import java.time.LocalDateTime;

public record ArtifactDto(
        long id,
        ArtifactDimensionDto artifactDimension,
        ArtifactPositionDto artifactPosition,
        ArtifactRotationDto artifactRotation,
        String label,
        String category,
        boolean analysisComplete,
        String thumbnail,
        long sectionId,
        long archeologistId,
        //long labScanId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
