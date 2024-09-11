package ro.ubb.abc2024.arheo.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record ArtifactDto(
        long id,
        ArtifactDimensionDto artifactDimension,
        ArtifactPositionDto artifactPosition,
        ArtifactRotationDto artifactRotation,
        String label,
        String category,
        boolean analysisComplete,
        UUID thumbnailId,
        UUID model3DId,
        List<UUID> imagesId,
        long sectionId,
        long archeologistId,
        //long labScanId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
