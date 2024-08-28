package ro.ubb.abc2024.biology.domain.teeth.deciduous;

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
public class DeciduousMaxillaIncisor1 extends DeciduousIncisor {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho winging;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho doubleShovel;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho rootSheathGroove;

}
