package ro.ubb.abc2024.biology.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class BioLab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Nullable
    private UUID artefactId;

}
