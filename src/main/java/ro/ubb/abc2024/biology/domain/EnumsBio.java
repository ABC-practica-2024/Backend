package ro.ubb.abc2024.biology.domain;

public class EnumsBio {

    public enum InventoryCondition {
        F("1-25% present"),
        P("25-75% present"),
        C("75-100% present"),
        A("Absent");

        private final String description;

        InventoryCondition(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum NonmetricTraits {
        ZERO("Absent"),
        ONE("Present/Partial"),
        TWO("Complete/Multiple"),
        NINE("Unobservable");

        private final String description;

        NonmetricTraits(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum StagesOfDJD {
        A("Normal articular surface"),
        B("Appearance of small deposits of bone on articular margins"),
        C("Small pits"),
        D("Polishing/eburnation"),
        E("Other (describe below)");

        private final String description;

        StagesOfDJD(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum ArtificialCranialModification {
        ONE("Yes"),
        TWO("No");

        private final String description;

        ArtificialCranialModification(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum Side {
        LEFT ("Left"),
        RIGHT ("Right"),
        USIDED ("U sided"),
        APPROXIMATED ("Approximated"),
        MID ("Middle");
        private final String description;

        Side(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum BoneHatch {
        TAN ("Tan"),
        BLACK ("Black"),
        WHITE_CALCINATED ("White or Calcinated"),
        BLUE_GRAY ("Blue or Gray");
        private final String description;

        BoneHatch(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum BoneCrematedHatch {
        TAN ("Tan"),
        BLACK ("Black"),
        WHITE_CALCINATED ("White or Calcinated"),
        BLUE_GRAY ("Blue or Gray");
        private final String description;

        BoneCrematedHatch(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // IncaBoneEnum.java
    public enum IncaBone {
        ZERO("absent"),
        ONE("complete, single bone"),
        TWO("bipartite"),
        THREE("tripartite"),
        FOUR("partial");

        private final String description;

        IncaBone(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum FlexureOfSuperiorSagittalSulcus {
        ONE("right"),
        TWO("left"),
        THREE("bifurcate");

        private final String description;

        FlexureOfSuperiorSagittalSulcus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum AnteriorNasalSpine {
        ZERO("absent or slight"),
        ONE("Intermediate"),
        TWO("marked");

        private final String description;

        AnteriorNasalSpine(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum InferiorNasalAperture {
        ONE("smooth transition"),
        TWO("angulation"),
        THREE("right angle with no sill"),
        FOUR("partial or weak sill"),
        FIVE("pronounced sill");

        private final String description;

        InferiorNasalAperture(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum InterorbitalBreadth {
        ONE("narrow"),
        TWO("medium"),
        THREE("broad");

        private final String description;

        InterorbitalBreadth(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MalarTubercle {
        ZERO("no projection"),
        ONE("trace tubercle (≤ 2 mm)"),
        TWO("medium protrusion (2-4 mm)"),
        THREE("pronounced tubercle (≥ 4 mm)");

        private final String description;

        MalarTubercle(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum NasalApertureShape {
        ONE("teardrop"),
        TWO("bell shape"),
        THREE("bowed");

        private final String description;

        NasalApertureShape(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum NasalApertureWidth {
        ONE("narrow"),
        TWO("medium"),
        THREE("wide");

        private final String description;

        NasalApertureWidth(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum NasalBoneContour {
        ZERO("low and rounded"),
        ONE("oval"),
        TWO("broad plateau"),
        THREE("narrow plateau"),
        FOUR("triangular (no plateau)");

        private final String description;

        NasalBoneContour(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum NasalBoneShape {
        ONE("no nasal pinch"),
        TWO("superior pinch & medium bulge"),
        THREE("superior pinch & pronounced bulge"),
        FOUR("triangular");

        private final String description;

        NasalBoneShape(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum NasalOvergrowth {
        ZERO("no overgrowth"),
        ONE("any projection beyond maxillary border");

        private final String description;

        NasalOvergrowth(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum NasofrontalSuture {
        ONE("round"),
        TWO("square"),
        THREE("triangular"),
        FOUR("irregular");

        private final String description;

        NasofrontalSuture(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum OrbitalShape {
        ONE("rectangular"),
        TWO("circular"),
        THREE("rhombic");

        private final String description;

        OrbitalShape(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PostbregmaticDepression {
        ZERO("no depression present"),
        ONE("marked depressed area");

        private final String description;

        PostbregmaticDepression(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PosteriorZygomaticTubercle {
        ZERO("no projection"),
        ONE("weak projection (< 4 mm)"),
        TWO("moderate projection (4-6 mm)"),
        THREE("marked projection (> 6 mm)");

        private final String description;

        PosteriorZygomaticTubercle(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum SuprnasalSuture {
        ZERO("completely obliterated"),
        ONE("open (unfused)"),
        TWO("closed, but visible");

        private final String description;

        SuprnasalSuture(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ZygomaticomaxillarySutureCourse {
        ZERO("no angles"),
        ONE("one angle, midline"),
        TWO("two or more angles");

        private final String description;

        ZygomaticomaxillarySutureCourse(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum TransversePalatineSuture {
        ONE("straight"),
        TWO("anterior deviation"),
        THREE("M-shaped"),
        FOUR("posterior deviation");

        private final String description;

        TransversePalatineSuture(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum Keeling {
        ZERO("absent"),
        ONE("present");

        private final String description;

        Keeling(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum InionHook {
        ZERO("absent"),
        ONE("marked inferior projection of external occipital protuberance");

        private final String description;

        InionHook(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum VenousMarkings {
        ZERO("absent"),
        ONE("linear depressions or grooves on frontal superior to temporal lines");

        private final String description;

        VenousMarkings(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MajorSutures {
        ONE("simple"),
        TWO("medium"),
        THREE("complex");

        private final String description;

        MajorSutures(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum OsJaponicum {
        ZERO("absent"),
        ONE("one or more sutures bisecting the zygomatic");

        private final String description;

        OsJaponicum(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ZygomaticProjectionNasalAperture {
        ONE("projecting"),
        TWO("intermediate"),
        THREE("retreating");

        private final String description;

        ZygomaticProjectionNasalAperture(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum NasalDepression {
        ONE("straight"),
        TWO("depressed"),
        THREE("deeply depressed");

        private final String description;

        NasalDepression(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PalatineTorus {
        ZERO("absent"),
        ONE("slight"),
        TWO("marked");

        private final String description;

        PalatineTorus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum DentalArcade {
        ONE("parabolic"),
        TWO("elliptic"),
        THREE("hyperbolic");

        private final String description;

        DentalArcade(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ChinShape {
        ONE("pointed"),
        TWO("blunt"),
        THREE("bilobate");

        private final String description;

        ChinShape(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MandibleLowerBorder {
        ONE("straight"),
        TWO("rocker"),
        THREE("undulating");

        private final String description;

        MandibleLowerBorder(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum SupraorbitalNotch {
        ZERO("absent"),
        ONE("present, < ½ occluded by spicules"),
        TWO("present, > ½ occluded by spicules"),
        THREE("present, degree of occlusion unknown"),
        FOUR("multiple notches");

        private final String description;

        SupraorbitalNotch(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum SupraorbitalForamen {
        ZERO("absent"),
        ONE("present"),
        TWO("multiple foramina");

        private final String description;

        SupraorbitalForamen(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MultipleInfraorbitalForamina {
        ZERO("absent"),
        ONE("internal division only"),
        TWO("two distinct foramina"),
        THREE("more than two distinct foramina");

        private final String description;

        MultipleInfraorbitalForamina(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ZygomaticoFacialForamina {
        ZERO("absent"),
        ONE("1 large"),
        TWO("1 large plus smaller f."),
        THREE("2 large"),
        FOUR("2 large plus smaller f."),
        FIVE("1 small"),
        SIX("multiple small");

        private final String description;

        ZygomaticoFacialForamina(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ParietalForamen {
        ZERO("absent"),
        ONE("present, on parietal"),
        TWO("present, sutural");

        private final String description;

        ParietalForamen(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum CondylarCanal {
        ZERO("not patent"),
        ONE("patent");

        private final String description;

        CondylarCanal(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum DividedHypoglossalCanal {
        ZERO("not patent"),
        ONE("partial, internal surface"),
        TWO("partial, within canal"),
        THREE("complete, internal surface"),
        FOUR("complete, within canal");

        private final String description;

        DividedHypoglossalCanal(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ForamenOvaleIncomplete {
        ZERO("absent"),
        ONE("partial formation"),
        TWO("no definition of foramen");

        private final String description;

        ForamenOvaleIncomplete(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ForamenSpinosumIncomplete {
        ZERO("absent"),
        ONE("partial formation"),
        TWO("no definition of foramen");

        private final String description;

        ForamenSpinosumIncomplete(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PterygoSpinousBridge {
        ZERO("absent"),
        ONE("trace (spicule only)"),
        TWO("partial bridge"),
        THREE("complete bridge");

        private final String description;

        PterygoSpinousBridge(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PterygoAlarBridge {
        ZERO("absent"),
        ONE("trace (spicule only)"),
        TWO("partial bridge"),
        THREE("complete bridge");

        private final String description;

        PterygoAlarBridge(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum TympanicDehiscence {
        ZERO("absent"),
        ONE("foramen only"),
        TWO("full defect present");

        private final String description;

        TympanicDehiscence(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum AuditoryExostosis {
        ZERO("absent"),
        ONE("< 1/3 canal occluded"),
        TWO("1/3-2/3 canal occluded"),
        THREE("> 2/3 canal occluded");

        private final String description;

        AuditoryExostosis(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MastoidForamenLocation {
        ZERO("absent"),
        ONE("temporal"),
        TWO("sutural"),
        THREE("occipital"),
        FOUR("both sutural and temporal"),
        FIVE("both occipital and temporal");

        private final String description;

        MastoidForamenLocation(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MastoidForamenNumber {
        ZERO("absent"),
        ONE("1"),
        TWO("2"),
        THREE("more than 2");

        private final String description;

        MastoidForamenNumber(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MentalForamen {
        ZERO("absent"),
        ONE("1"),
        TWO("2"),
        THREE("more than 2");

        private final String description;

        MentalForamen(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MandibularTorus {
        ZERO("absent"),
        ONE("trace (can palpate but not see)"),
        TWO("moderate: elevation between 2-5 mm"),
        THREE("marked: elevation greater than 5 mm");

        private final String description;

        MandibularTorus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum MylohyoidBridgeLocation {
        ZERO("absent"),
        ONE("near mandibular foramen"),
        TWO("center of groove"),
        THREE("both bridges described in 1) and 2) w/hiatus"),
        FOUR("both bridges described in 1) and 2) no hiatus");

        private final String description;

        MylohyoidBridgeLocation(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum SeptalAperture {
        ZERO("absent"),
        ONE("small foramen (pinhole) only"),
        TWO("true perforation");

        private final String description;

        SeptalAperture(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum CranialBoneAndTraits {
        FRONTAL("Frontal"),
        PARIETAL("Parietal"),
        OCCIPITAL("Occipital"),
        TEMPORAL("Temporal"),
        TMJ("Temporomandibular Joint"),
        MANDIBLE("Mandible"),
        ZYGOMATIC("Zygomatic"),
        MAXILLA("Maxilla"),
        NASAL("Nasal"),
        LACRIMAL("Lacrimal"),
        INFERIOR_NASAL_CONCHA("Inferior Nasal Concha"),
        PALATINE("Palatine"),
        SPHENOID("Sphenoid"),
        ETHMOID("Ethmoid"),
        VOMER("Vomer"),
        HYOID("Hyoid"),
        THYROID("Thyroid/Cricoid"),
        OSSICLES("Ossicles"),
        NONMETRIC_TRAITS_MID("Nonmetric traits mid elements"),
        NONMETRIC_TRAITS_SIDE("Nonmetric traits mid elements"),
        SUTURE_CLOSURE("Suture closure"),
        CRANIUM_MEASUREMENTS("Cranium measurements");

        private final String description;

        CranialBoneAndTraits(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

}