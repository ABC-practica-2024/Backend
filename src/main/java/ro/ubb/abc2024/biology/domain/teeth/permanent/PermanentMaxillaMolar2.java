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
public class PermanentMaxillaMolar2 extends PermanentMolar {

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


}
