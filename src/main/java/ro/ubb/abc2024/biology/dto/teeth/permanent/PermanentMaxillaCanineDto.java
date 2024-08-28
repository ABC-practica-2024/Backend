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
public class PermanentMaxillaCanineDto extends PermanentCanineDto {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho shovel;

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
    private EnumsBio.DentalMorpho accessRidges;
}

