package ro.ubb.abc2024.biology.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
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

    @Enumerated(EnumType.STRING)
    private EnumsBio.BoneCrematedHatch boneCrematedHatch;

}
