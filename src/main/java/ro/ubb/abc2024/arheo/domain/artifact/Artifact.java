package ro.ubb.abc2024.arheo.domain.artifact;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    //@ManyToOne
    //@JoinColumn(name = "section_id", nullable = false)
    // TODO: add Section instead of Object
    //private Object section;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "labscan_id", referencedColumnName = "id")
    // TODO: add LabScan instead of Object
    //private LabScan labScan;
    @CreationTimestamp
    @Column(updatable = false) // prevent updates to this field after creation
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

};


