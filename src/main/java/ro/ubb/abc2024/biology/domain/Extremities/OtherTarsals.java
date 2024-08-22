package ro.ubb.abc2024.biology.domain.Extremities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OtherTarsals extends Extremities {
    private EnumsBio.StagesOfDJD stagesOfDJD;
}