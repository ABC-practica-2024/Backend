package ro.ubb.abc2024.arheo.domain.artifact;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ArtifactPosition {
    private double latitude;
    private double longitude;
    private double depth;
}
