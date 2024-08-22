package ro.ubb.abc2024.biology.domain;

public class EnumsBio {

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
    public enum ExtremityBone {
        SCAPHOID("Scaphoid"),
        CALCANEUS("Calcaneus"),
        LUNATE("Lunate"),
        TRIQUETRUM("Triquetrum"),
        PISIFORM("Pisiform"),
        HAMATE("Hamate"),
        CAPITATE("Capitate"),
        TALUS("Talus"),
        NAVICULAR("Navicular"),
        CUBOID("Cuboid"),
        MEDIAL_CUNEIFORM("MedialCuneiform"),
        INTERMEDIATE_CUNEIFORM("IntermediateCuneiform"),
        LATERAL_CUNEIFORM("LateralCuneiform"),
        UPPER_SESAMOIDS("UpperSesamoids"),
        LOWER_SESAMOIDS("LowerSesamoids");

        private final String description;

        ExtremityBone(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum AppendicularType {
        HUMERUS("Humerus"),
        RADIUS("Radius"),
        ULNA("Ulna"),
        FEMUR("Femur"),
        TIBIA("Tibia"),
        FIBULA("Fibula");

        private final String description;

        AppendicularType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PathologyCondition {
        PRESENT("Present"),
        ABSENT("Absent"),
        UNOBS("Unobserved");

        private final String description;

        PathologyCondition(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum DigitsProxDistal {
        PROX("Proximal"),
        DISTAL("Distal");

        private final String description;

        DigitsProxDistal(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ToothType {
        M_ONE("Molar 1"),
        M_TWO("Molar 2"),
        M_THREE("Molar 3"),
        PM_ONE("Premolar 1"),
        PM_TWO("Premolar 2"),
        C("Canin"),
        I_ONE("Incisive 1"),
        I_TWO("Incisive 2");

        private final String description;

        ToothType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum GenericToothType {
        INCISORS("Incisors"),
        CANINES("Canines"),
        PREMOLARS("Premolars"),
        MOLARS("Molars");

        private final String description;

        GenericToothType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum BonesCondition {
        YES("Yes"),
        NO("No"),
        UNOBSERVABLE("Unobservable");

        private final String description;

        BonesCondition(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PhalangesHandFoot {
        HAND("Hand"),
        FOOT("Foot");

        private final String description;

        PhalangesHandFoot(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PhalangesPosition {
        PROX("Proximal"),
        MID("Middle"),
        DIST("Distal");

        private final String description;

        PhalangesPosition(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum VertebraeZoneType {
        CERVICAL("Cervical"),
        THORACIC("Thoracic"),
        LUMBAR("Lumbar"),
        SACRAL("Sacral");

        private final String description;

        VertebraeZoneType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum Sex {
        M("Male"),
        F("Female");

        private final String description;

        Sex(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum DentalMorpho {
        FALSE("False"),
        TRUE("True"),
        UNOBSERVABLE("Unobservable");

        private final String description;

        DentalMorpho(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum IsolatedRemainsType {
        CRANIAL("Cranial"),
        AXIAL("Axial"),
        APPENDICULAR("Appendicular"),
        EXTREMITIES("Extremities"),
        UNIDENTIFIED("Unidentified");

        private final String description;

        IsolatedRemainsType(String description) {
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
    public enum EstimatedAge {
        FETUS("Fetus"),
        INFANT("Infant (birth - 2 yr)"),
        CHILD("Child (2 - 12 yrs)"),
        SUBADULT("Subadult (12-20 yrs)"),
        YOUNG_ADULT("Young Adult (20-35 yrs)"),
        MIDDLE_ADULT("Middle Adult (35-50 yrs)"),
        OLD_ADULT("Old Adult (50+ yrs)");

        private final String description;

        EstimatedAge(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum RemainsCondition {
        ONE("Remains are burned"),
        TWO("Remains are consistent with human"),
        THREE("Remains are consistent with animal"),
        FOUR("Remains are not able to be determined (animal/human?)");

        private final String description;

        RemainsCondition(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum RemainsTexture {
        L("Longitudinally split"),
        T("Transversely splitting"),
        C("Curved cracks"),
        W("Warping");

        private final String description;

        RemainsTexture(String description) {
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
    public enum Transtubercle {
        ONE("Circumferential"),
        TWO("Squamous portion of occipital"),
        THREE("Below inion");

        private final String description;

        Transtubercle(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PlaneOfPressure {
        ONE("Perpendicular (90°)"),
        TWO("Obtuse (>90°)"),
        THREE("Acute (<90°)");

        private final String description;

        PlaneOfPressure(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PossiblePresence {
        ONE("Sagittal elevation"),
        TWO("Lambdic elevation"),
        THREE("Lambdic depression");

        private final String description;

        PossiblePresence(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum ConfirmationStatus {
        YES("Yes"),
        NO("No");

        private final String description;

        ConfirmationStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PadImpressions {
        ZERO("No pad impressions"),
        ONE("One pad"),
        TWO("Two pads"),
        THREE("More than two pads");

        private final String description;

        PadImpressions(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PadImpressionsShort {
        ZERO("No pad impressions"),
        ONE("One pad"),
        TWO("Two pads");

        private final String description;

        PadImpressionsShort(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PadLocation {
        ONE("Midline"),
        TWO("Symmetrically lateral to midline"),
        THREE("Asymmetrically left"),
        FOUR("Asymmetrically right");

        private final String description;

        PadLocation(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PadShape {
        ONE("Circular or oval"),
        TWO("Donut-shaped"),
        THREE("Triangular"),
        FOUR("Irregular form");

        private final String description;

        PadShape(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum PadPosition {
        ONE("High, near coronal suture"),
        TWO("Low, near or below frontal boss");

        private final String description;

        PadPosition(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public enum SymmetricalReshaping {
        ONE("Yes"),
        TWO("No, right side more deformed"),
        THREE("No, left side more deformed");

        private final String description;

        SymmetricalReshaping(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}