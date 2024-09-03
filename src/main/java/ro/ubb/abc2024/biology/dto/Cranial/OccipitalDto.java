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
public class OccipitalDto extends CranialDto {
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private Double occipitalChordAdult;

    @Nullable
    private Double foramenMagnumLengthAdult;

    @Nullable
    private Double foramenMagnumBreadthAdult;

    @Nullable
    private Double nuchalCrestAdult;

    @Nullable
    private Double occipitalLateralSquamaJuvenile;

    @Nullable
    private Double occipitalBasilarLateralJuvenile;

    @Nullable
    private Double basilarPartOccipitalWidthMidJuvenile;

    @Nullable
    private Double basilarPartOccipitalLengthLeftJuvenile;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD occipCondyles;

}
