package ro.ubb.abc2024.bio.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;

@Entity
public class LabScanMock {
    @Id
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "artifact_id", referencedColumnName = "id")
    private Artifact artifact;
}
