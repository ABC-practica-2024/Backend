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
public class DeciduousIncisorDto extends ToothDto {

    @Nullable
    private EnumsBio.DentalMorpho shovel;

    @Nullable
    private EnumsBio.DentalMorpho labialDefect;

    @Nullable
    private EnumsBio.DentalMorpho doubleTeeth;
}
