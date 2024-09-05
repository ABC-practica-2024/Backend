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
public class Humerus extends Appendicular {

    @Nullable
    private Double width;

    @Nullable
    private Double maxLengthAdult;

    @Nullable
    private Double epiCondylarBreadthAdult;

    @Nullable
    private Double verticalDiamHeadAdult;

    @Nullable
    private Double maxDiamMidshaftAdult;

    @Nullable
    private Double minDiamMidshaftAdult;

    @Nullable
    @Range(min=0, max=2)
    private Integer headStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer distalStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer medEpicondyleElbowStageOfUnion;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD distHumerusElbowStageOfDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD proxHumerusStageOfDJD;

}
