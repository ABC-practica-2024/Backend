package ro.ubb.abc2024.biology.domain;

import java.util.UUID;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BioLab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nullable
    private UUID designationID; // artefactId
    @Nullable
    private String formTitle;
    @Nullable
    private String formSubtitle;
    @Nullable
    @Builder.Default
    private boolean isFormChecked = false;

}