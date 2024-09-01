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
public class FemurDto extends AppendicularDto {

    @Nullable
    private Double width;

    @Nullable
    private Double maxLengthAdult;

    @Nullable
    private Double bicondylarLengthAdult;

    @Nullable
    private Double epicondylarBreadthAdult;

    @Nullable
    private Double maxDiamHeadAdult;

    @Nullable
    private Double apSubtrochDiamAdult;

    @Nullable
    private Double mlSubtrochDiamAdult;

    @Nullable
    private Double apMidshaftDiamAdult;

    @Nullable
    private Double mlMidshaftDiamAdult;

    @Nullable
    private Double midshaftCircumferenceAdult;

    @Nullable
    private Double lengthJuvenile;

    @Nullable
    private Double diameterJuvenile;

    @Nullable
    @Range(min=0, max=2)
    private Integer headStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer greaterTrochanterStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer lesserTrochanterStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer distalStageOfUnion;

    @Nullable
    private EnumsBio.StagesOfDJD femoralHeadHipStageOfDJD;

    @Nullable
    private EnumsBio.StagesOfDJD greaterTrochHipStageOfDJD;

    @Nullable
    private EnumsBio.StagesOfDJD lesserTrochHipStageOfDJD;

    @Nullable
    private EnumsBio.StagesOfDJD distFemurKneeStageOfDJD;

}
