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
public class PermanentMaxillaPremolar1Dto extends PermanentPremolarDto {

    @Nullable
    private EnumsBio.DentalMorpho doubleShovel;

    @Nullable
    private EnumsBio.DentalMorpho tuberculumDentale;

    @Nullable
    private EnumsBio.DentalMorpho accessCusps;

    @Nullable
    private EnumsBio.DentalMorpho accessRidges;

    @Nullable
    private EnumsBio.DentalMorpho triCuspedPMs;

}
