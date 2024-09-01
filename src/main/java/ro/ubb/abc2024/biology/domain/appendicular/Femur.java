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
public class Femur extends Appendicular {

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
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD femoralHeadHipStageOfDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD greaterTrochHipStageOfDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD lesserTrochHipStageOfDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD distFemurKneeStageOfDJD;

}
