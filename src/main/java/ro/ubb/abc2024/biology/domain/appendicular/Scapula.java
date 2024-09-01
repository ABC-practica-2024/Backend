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
public class Scapula extends Append {

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
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition glenoidInventoryCondition;

    @Nullable
    @Range(min=0, max=2)
    private Integer coracoidStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer acromionStageOfUnion;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD glenoidStagesOfDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD acromiumStagesOfDJD;

}

