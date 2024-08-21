package ro.ubb.abc2024.arheo.domain.site;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(unique = true)
    String title;

    String description;

    @Embedded
    SiteCoordinates coordinates;

    SiteStatus status;

    LocalDateTime createdAt;

    //@OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    // List<Section> sections;  // TODO add this after the merge

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    User mainArchaelogist;

    @ManyToMany
    @JoinTable(
            name = "site_archaelogist",
            joinColumns = @JoinColumn(name = "site_id"),
            inverseJoinColumns = @JoinColumn(name = "archaelogist_id")
    )
    List<User> archaelogists;
}
