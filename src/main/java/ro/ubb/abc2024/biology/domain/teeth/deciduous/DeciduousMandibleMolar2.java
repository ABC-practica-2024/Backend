package ro.ubb.abc2024.biology.domain.teeth.deciduous;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.teeth.Tooth;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DeciduousMandibleMolar2 extends Tooth {

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
