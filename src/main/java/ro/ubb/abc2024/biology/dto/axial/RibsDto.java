package ro.ubb.abc2024.biology.dto.axial;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class RibsDto extends AxialDto {

    @Nullable
    private EnumsBio.Side side;

    @Nullable
    private Integer ribsNo;

    @Nullable
    private EnumsBio.InventoryCondition inventoryCondition;

}
