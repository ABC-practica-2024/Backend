package ro.ubb.abc2024.biology.domain.axial;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Coccyx extends Axial {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private Integer coccyxNo;

}
