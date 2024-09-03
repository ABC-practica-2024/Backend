package ro.ubb.abc2024.biology.dto.Cranial;

import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class NonmetricTraitsSideElementDto extends CranialDto {
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.SupraorbitalNotch supraorbitalNotch;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.SupraorbitalForamen supraorbitalForamen;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits infraorbitalSuture;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MultipleInfraorbitalForamina multipleInfraorbitalForamina;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ZygomaticoFacialForamina zygomaticoFacialForamina;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ParietalForamen parietalForamen;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesEpitericBone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesCoronalOssicle;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesLambdoidOssicle;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesAsterionicBone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesOssicleInOccipitoMastoidSuture;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesParietalNotchBone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.CondylarCanal condylarCanal;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DividedHypoglossalCanal divideHypoglossalCanal;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ForamenOvaleIncomplete foramenOvaleIncomplete;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ForamenSpinosumIncomplete foramenSpinosumIncomplete;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.PterygoSpinousBridge pterygoSpinousBridge;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.PterygoAlarBridge pterygoAlarBridge;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.TympanicDehiscence tympanicDehiscence;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.AuditoryExostosis auditoryExostosis;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MastoidForamenLocation mastoidForamenLocation;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MastoidForamenNumber mastoidForamenNumber;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MentalForamen mentalForamen;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MandibularTorus mandibularTorus;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MylohyoidBridgeLocation mylohyoidBridgeLocation;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits mylohyoidBridgeDegree;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits atlasBridgingLateralBridging;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits atlasBridgingPosteriorBridging;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.SeptalAperture septalAperture;

}

