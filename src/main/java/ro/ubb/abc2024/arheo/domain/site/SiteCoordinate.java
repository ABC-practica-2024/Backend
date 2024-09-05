package ro.ubb.abc2024.arheo.domain.site;

import jakarta.persistence.Embeddable;
import lombok.*;


@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteCoordinate {
    private double latitude;
    private double longitude;
    private int orderIndex;

}
