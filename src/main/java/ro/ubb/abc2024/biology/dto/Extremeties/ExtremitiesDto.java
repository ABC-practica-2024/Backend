package ro.ubb.abc2024.biology.dto.Extremeties;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.BoneDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class ExtremitiesDto extends BoneDto {
    int bonesNo;
    EnumsBio.InventoryCondition inventoryCondition;
    EnumsBio.ExtremityBone boneType;
}
