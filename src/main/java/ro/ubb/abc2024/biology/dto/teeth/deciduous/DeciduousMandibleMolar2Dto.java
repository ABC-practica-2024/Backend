package ro.ubb.abc2024.biology.dto.teeth.deciduous;

import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho groovePattern;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho cuspNumber;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho deflectingWrinkle;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho distalTrigonCrest;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho protostylid;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho cusp5;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho rootNumber;

}
