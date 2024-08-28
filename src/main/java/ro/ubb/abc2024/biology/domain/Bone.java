package ro.ubb.abc2024.biology.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

//@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Bone extends BioLab {
    @Nullable
    private String boneName;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.Side boneSide;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.BoneHatch boneHatch;

    @Enumerated(EnumType.STRING)
    private EnumsBio.BoneCrematedHatch boneCrematedHatch;

}
