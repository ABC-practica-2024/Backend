package ro.ubb.abc2024.biology.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Bone extends BioLab {
    @Nullable
    private String boneName;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.Side boneSide;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.BoneHatch boneHatch;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.BoneCrematedHatch boneCrematedHatch;

}
