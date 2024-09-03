package ro.ubb.abc2024.biology.domain.Cranial;

import jakarta.persistence.Entity;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class NonmetricTraitsMidElement extends Cranial {
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits metopicSuture;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesBregmaticBone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesSagittalOssicle;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits suturalBonesApicalBone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.IncaBone incaBone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.FlexureOfSuperiorSagittalSulcus flexureOfSuperiorSagittalSulcus;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.AnteriorNasalSpine anteriorNasalSpine;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InferiorNasalAperture inferiorNasalAperture;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InterorbitalBreadth interorbitalBreadth;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MalarTubercle malarTubercle;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NasalApertureShape nasalApertureShape;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NasalApertureWidth nasalApertureWidth;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NasalBoneContour nasalBoneContour;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NasalBoneShape nasalBoneShape;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NasalOvergrowth nasalOvergrowth;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NasofrontalSuture nasofrontalSuture;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.OrbitalShape orbitalShape;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.PostbregmaticDepression postbregmaticDepression;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.PosteriorZygomaticTubercle posteriorZygomaticTubercle;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.SuprnasalSuture suprnasalSuture;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ZygomaticomaxillarySutureCourse zygomaticomaxillarySutureCourse;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.TransversePalatineSuture transversePalatineSuture;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.Keeling keeling;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InionHook inionHook;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.VenousMarkings venousMarkings;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MajorSutures majorSutures;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.OsJaponicum osJaponicum;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ZygomaticProjectionNasalAperture zygomaticProjectionAtNasalAperture;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NasalDepression nasalDepression;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.PalatineTorus palatineTorus;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalArcade dentalArcade;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ChinShape chinShape;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MandibleLowerBorder mandibleLowerBorder;

}
