package ro.ubb.abc2024.biology.domain.teeth.deciduous;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Tooth;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DeciduousMaxillaMolar2 extends Tooth {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho metacone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho hypocone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho cusp5;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho carabelli;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho c2Parastyle;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho rootSheathGroove;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho rootNumber;

}
