package ro.ubb.abc2024.arheo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


// mocking the Artifact class; won't be used once the actual Artifact class is implemented
@Entity
public class ArtifactMock {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
