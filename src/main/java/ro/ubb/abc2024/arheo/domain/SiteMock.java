package ro.ubb.abc2024.arheo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


// mocking the Site class; won't be used once the actual Site class is implemented
@Entity
public class SiteMock {
    @Id
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @OneToMany(targetEntity = Section.class)
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    private List<Section> sections;
}
