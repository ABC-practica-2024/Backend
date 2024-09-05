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
public class HumerusDto extends AppendicularDto {

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
    private EnumsBio.StagesOfDJD distHumerusElbowStageOfDJD;

    @Nullable
    private EnumsBio.StagesOfDJD proxHumerusStageOfDJD;

}
