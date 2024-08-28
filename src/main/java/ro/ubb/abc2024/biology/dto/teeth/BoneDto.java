package ro.ubb.abc2024.biology.dto.teeth;

import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BoneDto extends BioLabDto {

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
