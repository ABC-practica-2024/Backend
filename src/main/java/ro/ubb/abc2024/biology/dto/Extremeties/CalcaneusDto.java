package ro.ubb.abc2024.biology.dto.Extremeties;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class CalcaneusDto extends ExtremityDto {

    double maxLength;
    double middleBreadth;
    EnumsBio.StagesOfDJD stagesOfDJD;
}
