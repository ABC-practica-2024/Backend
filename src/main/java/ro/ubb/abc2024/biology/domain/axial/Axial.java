package ro.ubb.abc2024.biology.domain.axial;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Axial extends Bone {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.AxialBoneType boneType;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.AxialBoneType axialBoneType;

}
