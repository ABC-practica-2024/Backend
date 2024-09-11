package ro.ubb.abc2024.arheo.domain.artifact;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.bio.domain.LabScanMock;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.utils.file.DbFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "artifacts")
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private ArtifactDimension dimension;
    private ArtifactPosition position;
    private ArtifactRotation rotation;
    @NotNull(message = "Label cannot be null")
    private String label;
    @NotNull(message = "Category cannot be null")
    // TODO: change the type to ENUM once we know the exact categories for artifacts
    private String category;
    private boolean analysisCompleted;

    @OneToOne
    @JoinColumn(name = "thumbnail_id", referencedColumnName = "id", nullable = true)
    private DbFile thumbnail;

    @OneToOne
    @JoinColumn(name = "3DModel_id", referencedColumnName = "id", nullable = true)
    private DbFile model3D;

    // many to one relationship with Section
    @ManyToOne(targetEntity = Section.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", referencedColumnName = "id", nullable = false)
    private Section section;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "archeologist_id", referencedColumnName = "id", nullable = false)
    private User archeologist;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "artifact")
    @JoinColumn(name = "lab_scan_id", referencedColumnName = "id")
    private LabScanMock labScan; // TODO: change to actual LabScan when implemented

    @OneToMany(targetEntity = ImageToArtifact.class, mappedBy = "artifact", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ImageToArtifact> images;

    @CreationTimestamp
    @Column(nullable = false, name = "created_at", updatable = false) // prevent updates to this field after creation
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = true, name = "updated_at")
    private LocalDateTime updatedAt;


}


