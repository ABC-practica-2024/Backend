package ro.ubb.abc2024.arheo.domain.section;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.site.Site;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Section {
    // long UID, automatically generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    // String name, not null
    // name/identification of the section
    @NotNull(message = "Name cannot be null")
    @Column(nullable = false, name = "name")
    private String name;

    // 4 GeographicPoints, not null
    // represent the corners of the section

    // south-west (bottom-left) corner
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "south_west_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "south_west_longitude"))
    })
    @NotNull(message = "South-west corner cannot be null")
    private GeographicPoint southWest;

    // north-west (top-left) corner
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "north_west_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "north_west_longitude"))
    })
    @NotNull(message = "North-west corner cannot be null")
    private GeographicPoint northWest;

    // north-east (top-right) corner
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "north_east_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "north_east_longitude"))
    })
    @NotNull(message = "North-east corner cannot be null")
    private GeographicPoint northEast;

    // south-east (bottom-right) corner
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "south_east_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "south_east_longitude"))
    })
    @NotNull(message = "South-east corner cannot be null")
    private GeographicPoint southEast;


    // status: DIGGING, ANALYSIS, COMPLETED, from enum
    // shows the stage of the section; nullable
    @Column(nullable = true, name = "status")
    private SectionStatus status;

    // timestamp, not null
    // the date when the section was created
    @CreationTimestamp
    @Column(nullable = false, name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // timestamp, nullable
    // the date when the section was last modified - stage changed

    @UpdateTimestamp
    @Column(nullable = true, name = "updated_at")
    private LocalDateTime updatedAt;

    // reference to the site, not null; Site to Section is 1 to many; Site has id
    // site to which the section belongs
    @ManyToOne(targetEntity = Site.class)
    @JoinColumn(name = "site_id", referencedColumnName = "id", nullable = false)
    private Site site;

    // list of artifacts, nullable; reference to the artifacts
    // list of artifacts found in the section
    @OneToMany(targetEntity = Artifact.class, mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    // join column correctly; artifacts are expected to have a section_id
    private List<Artifact> artifactsList;


}
