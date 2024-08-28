package ro.ubb.abc2024.biology.dto.Extremeties;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class MetatarsalsDto extends ExtremityDto{
    int proximalJuvenileStageOfUnion;
    int distalJuvenileStageOfUnion;
    EnumsBio.StagesOfDJD stagesOfDJD;
}
