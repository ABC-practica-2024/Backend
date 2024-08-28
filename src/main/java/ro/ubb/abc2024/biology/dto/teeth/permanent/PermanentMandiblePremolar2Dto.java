package ro.ubb.abc2024.biology.dto.teeth.permanent;

import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class PermanentMandiblePremolar2Dto extends PermanentPremolarDto {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho lingualCusps;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho congAbscence;

}
