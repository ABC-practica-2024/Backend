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
public class SternumDto extends AxialDto {

    @Nullable
    private EnumsBio.InventoryCondition sternumManubriumInventoryCondition;

    @Nullable
    private EnumsBio.InventoryCondition sternumBodyInventoryCondition;

    @Nullable
    private EnumsBio.InventoryCondition sternumXiphoidInventoryCondition;

    @Nullable
    private Double lengthMesostern;

    @Nullable
    private Double maxBreadth1st;
}
