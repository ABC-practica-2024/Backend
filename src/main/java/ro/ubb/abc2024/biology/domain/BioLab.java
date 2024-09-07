package ro.ubb.abc2024.biology.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BioLab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nullable
    private UUID artefactId;

}