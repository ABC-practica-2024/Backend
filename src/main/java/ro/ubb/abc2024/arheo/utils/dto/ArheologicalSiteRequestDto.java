package ro.ubb.abc2024.arheo.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.ubb.abc2024.arheo.domain.Status;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ArheologicalSiteRequestDto {
    // TODO: validator
    private double geograficCoordinates;
    private LocalDateTime createRequestTime;
    private Long arheoId;
}
