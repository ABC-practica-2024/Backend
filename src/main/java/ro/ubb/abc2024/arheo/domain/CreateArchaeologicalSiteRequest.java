package ro.ubb.abc2024.arheo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.ubb.abc2024.user.User;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "create_arheo_site_request")
public class CreateArchaeologicalSiteRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: change after Site class appearance
    @NotNull(message = "Coordinates cannot be null")
    private double geograficCoordinates;
    @NotNull(message = "Status cannot be null")
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull(message = "Request time cannot be null")
    private LocalDateTime createRequestTime;
    private LocalDateTime solveRequestTime;

    @ManyToOne
    @JoinColumn(name = "archeologist_id", nullable = false)
    private User archeologist;

}
