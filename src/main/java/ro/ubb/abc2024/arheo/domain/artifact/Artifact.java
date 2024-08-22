package ro.ubb.abc2024.arheo.domain.artifact;

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

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "artifacts")
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ArtifactDimension dimension ;
    private ArtifactPosition position;
    private ArtifactRotation rotation;
    @NotNull(message = "Label cannot be null")
    private String label;
    @NotNull(message = "Category cannot be null")
    private String category;
    private boolean analysisCompleted;
    private String thumbnail;

    // many to one relationship with Section
    @ManyToOne(targetEntity = Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "artifact")
    @JoinColumn(name = "lab_scan_id", referencedColumnName = "id")
    private LabScanMock labScan; // TODO: change to actual LabScan when implemented
    // and maybe make sure the OneToMany relationship is correct and what we want

    @CreationTimestamp
    @Column(updatable = false) // prevent updates to this field after creation
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}


