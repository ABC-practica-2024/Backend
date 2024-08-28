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
public class Calcaneus extends Extremity {
    private double maxLength;

    private double middleBreadth;
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD stagesOfDJD;

}