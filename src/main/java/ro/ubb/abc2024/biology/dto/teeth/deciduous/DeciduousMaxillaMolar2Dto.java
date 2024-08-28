package ro.ubb.abc2024.biology.dto.teeth.deciduous;


import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DeciduousMaxillaMolar2Dto extends ToothDto {

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
