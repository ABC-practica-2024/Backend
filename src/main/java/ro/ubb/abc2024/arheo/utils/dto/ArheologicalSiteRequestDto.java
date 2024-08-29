package ro.ubb.abc2024.arheo.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.ubb.abc2024.arheo.domain.Status;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.site.SiteCoordinate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ArheologicalSiteRequestDto {
    // TODO: validator
    private String title;
    private String description;
    private GeographicPoint centerCoordinates;
    private List<SiteCoordinate> perimeterCoordinates;
    private LocalDateTime createRequestTime;
    private Long arheoId;

}
