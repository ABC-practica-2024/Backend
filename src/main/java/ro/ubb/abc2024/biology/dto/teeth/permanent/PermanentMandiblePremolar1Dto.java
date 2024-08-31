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
public class PermanentMandiblePremolar1Dto extends PermanentPremolarDto {

    @Nullable
    private EnumsBio.DentalMorpho lingualCusps;

    @Nullable
    private EnumsBio.DentalMorpho cusp7;

}
