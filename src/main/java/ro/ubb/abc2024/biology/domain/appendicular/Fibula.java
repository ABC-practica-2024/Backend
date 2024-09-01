package ro.ubb.abc2024.biology.domain.appendicular;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Fibula extends Appendicular {

    @Nullable
    private Double maxLengthAdult;

    @Nullable
    private Double maxDiameterMidshaftAdult;

    @Nullable
    private Double lengthJuvenile;

    @Nullable
    private Double diameterJuvenile;

    @Nullable
    @Range(min=0, max=2)
    private Integer proximalStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer distalStageOfUnion;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD proxFibulaKneeStageOfDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD distFibulaAnklesStageOfDJD;

}
