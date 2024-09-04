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
public class Metacarpals extends Extremity {
    @Range(min=0, max=2)
    private int proximalJuvenileStageOfUnion;
    @Range(min=0, max=2)
    private int distalJuvenileStageOfUnion;
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD stagesOfDJD;

}