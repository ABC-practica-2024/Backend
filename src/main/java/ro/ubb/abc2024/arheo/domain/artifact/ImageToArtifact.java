package ro.ubb.abc2024.arheo.domain.artifact;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.utils.file.DbFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image_to_artifacts")
public class ImageToArtifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = Artifact.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "artifact_id", referencedColumnName = "id", nullable = false)
    private Artifact artifact;

    @OneToOne
    @JoinColumn(name = "dbfile_id", referencedColumnName = "id", nullable = false, unique = true)
    private DbFile dbFile;
}
