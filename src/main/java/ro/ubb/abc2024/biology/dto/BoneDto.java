package ro.ubb.abc2024.biology.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class BoneDto {
    String boneName;
    EnumsBio.Side boneSide;
    EnumsBio.BoneHatch boneHatch;
    EnumsBio.BoneCrematedHatch boneCrematedHatch;
}
