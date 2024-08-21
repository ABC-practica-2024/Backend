package ro.ubb.abc2024.arheo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



// mocking the Site class; won't be used once the actual Site class is implemented
@Entity
public class SiteMock {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
