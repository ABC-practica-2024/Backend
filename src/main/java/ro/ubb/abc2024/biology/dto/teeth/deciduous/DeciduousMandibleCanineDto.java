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
public class DeciduousMandibleCanineDto extends ToothDto {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho rootGroove;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho dAR;
}
