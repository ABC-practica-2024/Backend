package ro.ubb.abc2024.biology.domain.teeth.permanent;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PermanentMandibleMolar1 extends PermanentMolar {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho antFovea;

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
    private EnumsBio.DentalMorpho midTrigonidCrest;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho distalTrigonidCrest;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho protstylid;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho cusp6;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho cusp7;

}
