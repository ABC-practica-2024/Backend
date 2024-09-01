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
public class FibulaDto extends AppendicularDto {

    @Nullable
    private Double maxLengthAdult;

    @Nullable
    private Double maxDiameterMidshaftAdult;

    @Nullable
    private Double lengthJuvenile;

    @Nullable
    private Double diameterJuvenile;

    @Nullable
    @Range(min=0, max=2)
    private Integer proximalStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer distalStageOfUnion;

    @Nullable
    private EnumsBio.StagesOfDJD proxFibulaKneeStageOfDJD;

    @Nullable
    private EnumsBio.StagesOfDJD distFibulaAnklesStageOfDJD;

}
