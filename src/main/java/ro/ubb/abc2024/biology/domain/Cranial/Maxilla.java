package ro.ubb.abc2024.biology.domain.Cranial;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Maxilla extends Cranial {
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private Double maxilloAlveolarBreadthAdult;

    @Nullable
    private Double maxilloAlveolarLengthAdult;

    @Nullable
    private Double maxillaLengthJuvenile;

    @Nullable
    private Double maxillaHeightJuvenile;

    @Nullable
    private Double maxillaWidthJuvenile;

}
