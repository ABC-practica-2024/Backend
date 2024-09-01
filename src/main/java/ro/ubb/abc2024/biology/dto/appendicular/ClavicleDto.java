package ro.ubb.abc2024.biology.dto.appendicular;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ClavicleDto extends AppendDto {

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
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
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
    private EnumsBio.StagesOfDJD medialStagesOfDJD;

    @Nullable
    private EnumsBio.StagesOfDJD lateralStagesOfDJD;

}
