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
public class IliumDto extends AppendDto {

    @Nullable
    private Double length;

    @Nullable
    private Double width;

    @Nullable
    private Double iliacBreadth;

    @Nullable
    @Range(min=1, max=8)
    private Integer auricularSurfaceLovejoyEtAl;

    @Nullable
    @Range(min=1, max=5)
    private Integer greaterSciaticNotch;

    @Nullable
    @Range(min=0, max=4)
    private Integer preauricularSulcus;

    @Nullable
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private EnumsBio.InventoryCondition auricularInventoryCondition;

    @Nullable
    @Range(min=0, max=2)
    private Integer iliumPubisStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer ischiumIliumStageOfUnion;

}
