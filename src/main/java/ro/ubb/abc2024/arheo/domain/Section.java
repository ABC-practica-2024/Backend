package ro.ubb.abc2024.arheo.domain;


import jakarta.persistence.*;
import lombok.Data;

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
    private GeographicPoint southWest;

    // north-west (top-left) corner
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "north_west_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "north_west_longitude"))
    })
    private GeographicPoint northWest;

    // north-east (top-right) corner
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "north_east_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "north_east_longitude"))
    })
    private GeographicPoint northEast;

    // south-east (bottom-right) corner
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "south_east_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "south_east_longitude"))
    })
    private GeographicPoint southEast;


    // status: DIGGING, ANALYSIS, COMPLETED, from enum
    // shows the stage of the section; nullable
    @Column(nullable = true, name = "status")
    private SectionStatus status;

    // timestamp, not null
    // the date when the section was created
    @Column(nullable = false, name = "timestamp_created")
    private long timestampCreated;

    // timestamp, nullable
    // the date when the section was last modified - stage changed
    @Column(nullable = true, name = "last_modified")
    private long lastModified;

    // reference to the site, not null; Site to Section is 1 to many; Site has id
    // site to which the section belongs
    @ManyToOne(targetEntity = SiteMock.class) // TODO: change mock to actual class
    @JoinColumn(name = "site_id", referencedColumnName = "id", nullable = false)
    private SiteMock site;  // TODO: change mock to actual class

    // list of artifacts, nullable; reference to the artifacts
    // list of artifacts found in the section
    @OneToMany(targetEntity = ArtifactMock.class) // TODO: change mock to actual class
    // join column correctly; artifacts are expected to have a section_id
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private List<ArtifactMock> artifactsList; // TODO: change mock to actual class


}
