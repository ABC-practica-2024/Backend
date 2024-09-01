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
public class RadiusDto extends AppendicularDto {

    @Nullable
    private Double maxLength;

    @Nullable
    private Double antPostDiamMidshaft;

    @Nullable
    private Double medLatDiamMidshaft;

    @Nullable
    private Double diameterJuvenile;

    @Nullable
    @Range(min=0, max=2)
    private Integer proximalStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer distalStageOfUnion;

    @Nullable
    private EnumsBio.StagesOfDJD proxRadiusElbowStagesOfDJD;

    @Nullable
    private EnumsBio.StagesOfDJD distRadiusWristStagesOfDJD;

}
