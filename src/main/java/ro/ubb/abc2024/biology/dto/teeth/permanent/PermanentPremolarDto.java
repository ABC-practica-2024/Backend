package ro.ubb.abc2024.biology.dto.teeth.permanent;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PermanentPremolarDto extends ToothDto {

    @Nullable
    private EnumsBio.DentalMorpho odontome;

    @Nullable
    private EnumsBio.DentalMorpho enamelExt;

    @Nullable
    private EnumsBio.DentalMorpho rootNumber;

    @Nullable
    private EnumsBio.DentalMorpho radicalNumber;
}
