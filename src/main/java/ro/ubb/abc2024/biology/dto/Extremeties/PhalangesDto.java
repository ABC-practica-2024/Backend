package ro.ubb.abc2024.biology.dto.Extremeties;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class PhalangesDto extends ExtremityDto {
    int proximalJuvenile;
    EnumsBio.PhalangesHandFoot handOrFoot;
    EnumsBio.PhalangesPosition position;

    EnumsBio.StagesOfDJD stagesOfDJD;
}
