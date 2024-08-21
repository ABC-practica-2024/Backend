package ro.ubb.abc2024.arheo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


// mocking the Artifact class; won't be used once the actual Artifact class is implemented
@Entity
public class ArtifactMock {
    @Getter
    @Setter
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private double section_id;


}
