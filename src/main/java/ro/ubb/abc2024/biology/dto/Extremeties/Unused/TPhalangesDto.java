package ro.ubb.abc2024.biology.dto.Extremeties.Unused;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.Extremeties.ExtremityDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class TPhalangesDto extends ExtremityDto {
    int proximalJuvenileStageOfUnion;
    EnumsBio.PhalangesPosition position;
    EnumsBio.StagesOfDJD stagesOfDJD;
}
