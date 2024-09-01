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
public class ScapulaDto extends AppendDto {

    @Nullable
    private Double lengthHT;

    @Nullable
    private Double width;

    @Nullable
    private Double spineLength;

    @Nullable
    private Double heightAdult;

    @Nullable
    private Double breadthAdult;

    @Nullable
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private EnumsBio.InventoryCondition glenoidInventoryCondition;

    @Nullable
    @Range(min=0, max=2)
    private Integer coracoidStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer acromionStageOfUnion;

    @Nullable
    private EnumsBio.StagesOfDJD glenoidStagesOfDJD;

    @Nullable
    private EnumsBio.StagesOfDJD acromiumStagesOfDJD;

}

