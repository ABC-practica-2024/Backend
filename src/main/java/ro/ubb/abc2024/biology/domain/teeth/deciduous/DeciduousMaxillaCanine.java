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
public class DeciduousMaxillaCanine extends Tooth {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho shovel;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho doubleShovel;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho doubleTeeth;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho labialDefect;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho canineForm;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho rootSheathGroove;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho dAR;
}
