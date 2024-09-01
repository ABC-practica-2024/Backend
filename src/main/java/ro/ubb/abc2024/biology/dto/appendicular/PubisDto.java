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
public class PubisDto extends AppendDto {

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
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private EnumsBio.InventoryCondition symphysisInventoryCondition;

    @Nullable
    @Range(min=0, max=2)
    private Integer stageOfUnionInnominatelliumPubis;

    @Nullable
    @Range(min=0, max=2)
    private Integer stageOfUnionInnominatelschiumPubis;

}
