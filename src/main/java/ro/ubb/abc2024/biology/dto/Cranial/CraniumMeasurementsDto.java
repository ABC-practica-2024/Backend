package ro.ubb.abc2024.biology.dto.Cranial;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CraniumMeasurementsDto extends CranialDto {


    @Nullable
    private Double maxCranialLengthAdult;

    @Nullable
    private Double maxCranialBreadthAdult;

    @Nullable
    private Double basionBregmaHeightAdult;

    @Nullable
    private Double basionNasionLengthAdult;

    @Nullable
    private Double basionProsthionLengthAdult;

    @Nullable
    private Double upperFacialHeightAdult;

    @Nullable
    private Double upperFacialBreadthAdult;

    @Nullable
    private Double nasalHeightAdult;

    @Nullable
    private Double nasalBreadthAdult;

    @Nullable
    private Double orbitalBreadthAdult;

    @Nullable
    private Double orbitalHeightAdult;

    @Nullable
    private Double biorbitalBreadthAdult;

    @Nullable
    private Double interorbitalBreadthAdult;
}
