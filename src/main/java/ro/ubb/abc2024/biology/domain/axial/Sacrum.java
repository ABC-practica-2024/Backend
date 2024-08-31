package ro.ubb.abc2024.biology.domain.axial;

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
public class Sacrum extends Axial {

    @Nullable
    private Integer sacrumNo;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    @Range(min=0, max=3)
    private Integer s1s2Fusion;

    @Nullable
    @Range(min=0, max=2)
    private Integer stageOfUnion12;

    @Nullable
    @Range(min=0, max=2)
    private Integer stageOfUnion23;

    @Nullable
    @Range(min=0, max=2)
    private Integer stageOfUnion34;

    @Nullable
    @Range(min=0, max=2)
    private Integer stageOfUnion45;

    @Nullable
    private Double anteriorLength;

    @Nullable
    private Double anteriorSuperiorBreadth;

    @Nullable
    private Double maxTransDiamBase;
}
