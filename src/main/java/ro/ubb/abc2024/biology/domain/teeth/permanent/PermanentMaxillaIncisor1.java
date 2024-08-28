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
public class PermanentMaxillaIncisor1 extends PermanentIncisor {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho winging;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho labialCurve;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho interruptGroove;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho tuberculumDentale;
}

