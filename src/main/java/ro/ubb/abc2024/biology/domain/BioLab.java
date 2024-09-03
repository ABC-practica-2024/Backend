package ro.ubb.abc2024.biology.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BioLab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nullable
    private UUID artefactId;

}