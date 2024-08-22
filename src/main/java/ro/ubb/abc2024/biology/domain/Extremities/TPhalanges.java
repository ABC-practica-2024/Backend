package ro.ubb.abc2024.biology.domain.Extremities;

import jakarta.persistence.*;
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
public class TPhalanges extends Extremities {
    @Range(min=0, max=2) //verifica sa includa si valoarea min si max
    private int proximalJuvenileStageOfUnion;
    @Enumerated(EnumType.STRING)
    private EnumsBio.PhalangesPosition position;
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD stagesOfDJD;

}