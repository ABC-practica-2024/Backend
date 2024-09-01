package ro.ubb.abc2024.biology.domain.appendicular;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Appendicular extends Append {

    @Nullable
    private Double length;

    @Nullable
    private Double diameter;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition epiP;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition prox;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition mid;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition dist;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition epiD;

}
