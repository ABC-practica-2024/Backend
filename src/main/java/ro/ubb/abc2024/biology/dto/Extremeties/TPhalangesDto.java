package ro.ubb.abc2024.biology.dto.Extremeties;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class TPhalangesDto {
    int proximalJuvenileStageOfUnion;
    EnumsBio.PhalangesPosition position;
    EnumsBio.StagesOfDJD stagesOfDJD;
}
