package ro.ubb.abc2024.biology.dto.teeth.permanent;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PermanentMandibleMolar2Dto extends PermanentMolarDto {

    @Nullable
    private EnumsBio.DentalMorpho groovePattern;

    @Nullable
    private EnumsBio.DentalMorpho cuspNumber;

    @Nullable
    private EnumsBio.DentalMorpho deflectingWrinkle;

    @Nullable
    private EnumsBio.DentalMorpho midTrigonidCrest;

    @Nullable
    private EnumsBio.DentalMorpho distalTrigonidCrest;

    @Nullable
    private EnumsBio.DentalMorpho protstylid;

    @Nullable
    private EnumsBio.DentalMorpho cusp6;

    @Nullable
    private EnumsBio.DentalMorpho cusp7;

}
