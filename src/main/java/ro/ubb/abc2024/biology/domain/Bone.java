package ro.ubb.abc2024.biology.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Bone extends BioLab {
    private String boneName;

    @Enumerated(EnumType.STRING)
    private EnumsBio.Side boneSide;

    @Enumerated(EnumType.STRING)
    private EnumsBio.BoneHatch boneHatch;

    @Enumerated(EnumType.STRING)
    private EnumsBio.BoneCrematedHatch boneCrematedHatch;

}
