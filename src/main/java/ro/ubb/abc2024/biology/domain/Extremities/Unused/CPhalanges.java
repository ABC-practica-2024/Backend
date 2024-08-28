package ro.ubb.abc2024.biology.domain.Extremities.Unused;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CPhalanges extends Extremity {
    @Range(min=0, max=2) //verifica sa includa si valoarea min si max
    private int proximalJuvenileStageOfUnion;
    @Enumerated(EnumType.STRING)
    private EnumsBio.PhalangesPosition position;
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD stagesOfDJD;

}
