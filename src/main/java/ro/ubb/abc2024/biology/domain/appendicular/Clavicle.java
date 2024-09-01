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
public class Clavicle extends Append {

    @Nullable
    private Double length;

    @Nullable
    private Double diameter;

    @Nullable
    private Double maxLengthAdult;

    @Nullable
    private Double apDiamMidshaftAdult;

    @Nullable
    private Double supInfDiamMidshaftAdult;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition medEpiInventoryCondition;

    @Nullable
    @Range(min=0, max=3)
    private Integer sternalEpiphysisAdult;

    @Nullable
    @Range(min=0, max=2)
    private Integer epiphysealUnionAdult;

    @Nullable
    @Range(min=0, max=2)
    private Integer sternalJuvenileStageOfUnion;

    @Nullable
    @Range(min=0, max=3)
    private Integer sternalAdultStageOfUnion;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD medialStagesOfDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD lateralStagesOfDJD;

}
