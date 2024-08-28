package ro.ubb.abc2024.biology.domain.teeth.permanent;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PermanentMaxillaPremolar2 extends PermanentPremolar {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho doubleShovel;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho tuberculumDentale;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho accessCusps;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho tricuspidRidges;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho congAbsence;
}
