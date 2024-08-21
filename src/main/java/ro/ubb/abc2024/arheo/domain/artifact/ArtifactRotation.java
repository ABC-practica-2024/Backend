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
public class ArtifactRotation {
    private double pitch;
    private double yaw;
    private double roll;
}
