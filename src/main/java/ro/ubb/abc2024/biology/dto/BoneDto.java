package ro.ubb.abc2024.biology.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.BioLab;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BoneDto extends BioLab {
    @Nullable
    private String boneName;

    @Nullable
    private EnumsBio.Side boneSide;

    @Nullable
    private EnumsBio.BoneHatch boneHatch;

    private EnumsBio.BoneCrematedHatch boneCrematedHatch;

}
