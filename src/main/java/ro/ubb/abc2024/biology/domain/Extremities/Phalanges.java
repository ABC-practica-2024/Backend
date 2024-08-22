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
public class Phalanges extends Extremities {
    @Range(min=0, max=2) //verifica sa includa si valoarea min si max
    private int proximalJuvenile;

    @Enumerated(EnumType.STRING)
    private EnumsBio.PhalangesHandFoot handOrFoot;

    @Enumerated(EnumType.STRING)
    private EnumsBio.PhalangesPosition position;

}