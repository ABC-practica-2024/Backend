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
public class PermanentMaxillaIncisor2Dto extends PermanentIncisorDto {

    @Nullable
    private EnumsBio.DentalMorpho labialCurve;

    @Nullable
    private EnumsBio.DentalMorpho interruptGroove;

    @Nullable
    private EnumsBio.DentalMorpho tuberculumDentale;

    @Nullable
    private EnumsBio.DentalMorpho pegReduced;

    @Nullable
    private EnumsBio.DentalMorpho congAbsence;
}
