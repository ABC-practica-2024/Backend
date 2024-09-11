package ro.ubb.abc2024.arheo.domain.site;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;

import java.time.LocalDateTime;
import java.util.List;

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

    @NotNull(message = "Title cannot be null")
    String title;

    String description;

    // TODO: change after Site class appearance
    @NotNull(message = "Coordinates cannot be null")
    @Embedded
    GeographicPoint centerCoordinates;

    @ElementCollection
    @Fetch(FetchMode.JOIN)
    @CollectionTable(name = "site_creation_requests_coordinates")
    List<SiteCoordinate> perimeterCoordinates;

    @NotNull(message = "Status cannot be null")
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @NotNull(message = "Request time cannot be null")
    private LocalDateTime createRequestTime;
    private LocalDateTime solveRequestTime;

    @ManyToOne
    @JoinColumn(name = "archeologist_id", nullable = false)
    private User archeologist;

}
