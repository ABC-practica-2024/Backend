package ro.ubb.abc2024.biology.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class BoneDto extends BioLabDto{
    String boneName;
    EnumsBio.Side boneSide;
    EnumsBio.BoneHatch boneHatch;
    EnumsBio.BoneCrematedHatch boneCrematedHatch;
}
