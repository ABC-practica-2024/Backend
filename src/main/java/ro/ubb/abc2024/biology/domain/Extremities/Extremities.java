package ro.ubb.abc2024.biology.domain.Extremities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Extremities extends Bone {
    @Nullable
    private int bonesNo;
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ExtremityBone boneType;

}