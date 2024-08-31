package ro.ubb.abc2024.biology.dto.teeth.permanent;

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
public class PermanentMaxillaMolar2Dto extends PermanentMolarDto {

    @Nullable
    private EnumsBio.DentalMorpho metacone;

    @Nullable
    private EnumsBio.DentalMorpho hypocone;

    @Nullable
    private EnumsBio.DentalMorpho carabelli;

    @Nullable
    private EnumsBio.DentalMorpho c2Parastyle;

}
