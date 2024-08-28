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
public class PermanentMaxillaMolar3Dto extends PermanentMolarDto {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho metacone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho hypocone;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho carabelli;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho c2Parastyle;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho pegReduced;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.DentalMorpho congAbsence;

}
