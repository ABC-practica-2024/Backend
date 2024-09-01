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
public class Ilium extends Append {

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
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition auricularInventoryCondition;

    @Nullable
    @Range(min=0, max=2)
    private Integer iliumPubisStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer ischiumIliumStageOfUnion;

}
