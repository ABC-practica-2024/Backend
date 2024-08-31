package ro.ubb.abc2024.biology.dto.teeth.deciduous;


import jakarta.annotation.Nullable;
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
    private EnumsBio.DentalMorpho metacone;

    @Nullable
    private EnumsBio.DentalMorpho hypocone;

    @Nullable
    private EnumsBio.DentalMorpho cusp5;

    @Nullable
    private EnumsBio.DentalMorpho carabelli;

    @Nullable
    private EnumsBio.DentalMorpho c2Parastyle;

    @Nullable
    private EnumsBio.DentalMorpho rootSheathGroove;

    @Nullable
    private EnumsBio.DentalMorpho rootNumber;

}
