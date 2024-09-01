package ro.ubb.abc2024.biology.domain.appendicular;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Pubis extends Append {

    @Nullable
    private Double length;

    @Nullable
    private Double pelvisHeight;

    @Nullable
    @Range(min=1, max=10)
    private Integer symphysisTodd;

    @Nullable
    @Range(min=1, max=6)
    private Integer symphysisSucheyBrooks;

    @Nullable
    @Range(min=1, max=3)
    private Integer ventralArc;

    @Nullable
    @Range(min=1, max=3)
    private Integer subpubicConcavity;

    @Nullable
    @Range(min=1, max=3)
    private Integer ischiopubicRamusRidge;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition symphysisInventoryCondition;

    @Nullable
    @Range(min=0, max=2)
    private Integer stageOfUnionInnominatelliumPubis;

    @Nullable
    @Range(min=0, max=2)
    private Integer stageOfUnionInnominatelschiumPubis;

}
