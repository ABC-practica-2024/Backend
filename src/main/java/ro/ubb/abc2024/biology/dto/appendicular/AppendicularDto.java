package ro.ubb.abc2024.biology.dto.appendicular;

import jakarta.annotation.Nullable;
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
public class AppendicularDto extends AppendDto {

    @Nullable
    private Double length;

    @Nullable
    private Double diameter;

    @Nullable
    private EnumsBio.InventoryCondition epiP;

    @Nullable
    private EnumsBio.InventoryCondition prox;

    @Nullable
    private EnumsBio.InventoryCondition mid;

    @Nullable
    private EnumsBio.InventoryCondition dist;

    @Nullable
    private EnumsBio.InventoryCondition epiD;

}
