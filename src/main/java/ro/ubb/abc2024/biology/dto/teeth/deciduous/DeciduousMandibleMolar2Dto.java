package ro.ubb.abc2024.biology.dto.teeth.deciduous;

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
public class DeciduousMandibleMolar2Dto extends ToothDto {

    @Nullable
    private EnumsBio.DentalMorpho groovePattern;

    @Nullable
    private EnumsBio.DentalMorpho cuspNumber;

    @Nullable
    private EnumsBio.DentalMorpho deflectingWrinkle;

    @Nullable
    private EnumsBio.DentalMorpho distalTrigonCrest;

    @Nullable
    private EnumsBio.DentalMorpho protostylid;

    @Nullable
    private EnumsBio.DentalMorpho cusp5;

    @Nullable
    private EnumsBio.DentalMorpho rootNumber;

}
