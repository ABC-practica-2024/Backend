package ro.ubb.abc2024.biology.dto.teeth.deciduous;

import jakarta.annotation.Nullable;
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
public class DeciduousMandibleIncisor2Dto extends DeciduousIncisorDto {

    @Nullable
    private EnumsBio.DentalMorpho dar;

    @Nullable
    private EnumsBio.DentalMorpho rootGroove;

}
