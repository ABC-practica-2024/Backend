package ro.ubb.abc2024.biology.domain.axial;

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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Ribs extends Axial {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.Side side;

    @Nullable
    private Integer ribsNo;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

}
