package ro.ubb.abc2024.biology.domain.Extremities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Phalanges extends Extremity {
    @Range(min=0, max=2)
    private int proximalJuvenile;

    @Enumerated(EnumType.STRING)
    private EnumsBio.PhalangesHandFoot handOrFoot;

    @Enumerated(EnumType.STRING)
    private EnumsBio.PhalangesPosition position;

    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD stagesOfDJD;

}