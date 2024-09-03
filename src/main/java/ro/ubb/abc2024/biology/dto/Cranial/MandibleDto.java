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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MandibleDto extends CranialDto {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private Double chinHeightAdult;

    @Nullable
    private Double mandibularBodyHeightAdult;

    @Nullable
    private Double mandibularBodyBreadthAdult;

    @Nullable
    private Double bigonialWidthAdult;

    @Nullable
    private Double bicondylarBreadthAdult;

    @Nullable
    private Double minimumRamusBreadthAdult;

    @Nullable
    private Double maximumRamusBreadthAdult;

    @Nullable
    private Double maximumRamusHeightAdult;

    @Nullable
    private Double mandibularLengthAdult;

    @Nullable
    private Double mandibularAngleAdult;

    @Nullable
    private Double mandibleBodyLengthJuvenile;

    @Nullable
    private Double mandibleWidthOfArcJuvenile;

    @Nullable
    private Double mandibleFullLengthJuvenile;

    @Nullable
    private Double mandibularSymphysisJuvenile;

    @Nullable
    private Double mentalEminenceAdult;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD mandCondyles;

}