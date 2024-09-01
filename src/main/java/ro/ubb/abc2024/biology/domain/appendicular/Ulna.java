package ro.ubb.abc2024.biology.domain.appendicular;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Ulna extends Appendicular {

    @Nullable
    private Double maxLength;

    @Nullable
    private Double apDiameter;

    @Nullable
    private Double mlDiameter;

    @Nullable
    private Double diameterJuvenile;

    @Nullable
    private Double physiologicalLength;

    @Nullable
    private Double minCircumference;

    @Nullable
    @Range(min=0, max=2)
    private Integer proximalStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer distalStageOfUnion;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD proxUlnaElbowStageOfDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD distUlnaWristStageOfDJD;

}
