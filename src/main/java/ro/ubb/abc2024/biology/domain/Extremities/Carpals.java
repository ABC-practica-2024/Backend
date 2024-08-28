package ro.ubb.abc2024.biology.domain.Extremities;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Carpals extends Extremity {
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD stagesOfDJD;
}