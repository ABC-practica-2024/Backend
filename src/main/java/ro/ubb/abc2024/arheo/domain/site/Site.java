package ro.ubb.abc2024.arheo.domain.site;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title cannot be null")
    String title;

    String description;

    @NotNull(message = "Center coordinates cannot be null")
    @Embedded
    GeographicPoint centerCoordinates;

    @ElementCollection
    @Fetch(FetchMode.JOIN)
    @CollectionTable(name = "coordinates")
    List<SiteCoordinate> perimeterCoordinates;


    @Enumerated(EnumType.STRING)
    SiteStatus status;


    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime createdAt;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Section> sections;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    @NotNull(message = "Main archaelogist cannot be null")
    User mainArchaeologist;

    //todo: change at some point if needed from eager to lazy, not possible 2 left join fetches in the query from site repo
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "site_archaeologist",
            joinColumns = @JoinColumn(name = "site_id"),
            inverseJoinColumns = @JoinColumn(name = "archaelogist_id")
    )
    List<User> archaeologists;
}
