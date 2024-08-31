package ro.ubb.abc2024.biology.domain.axial;

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
public class Vertebrae extends Axial {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.VertebraeZoneType vertebraeZoneType;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.VertebraeType vertebraeType;

    @Nullable
    private Integer vertebraeNo;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits accessoryTransverseForaminaLeft;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.NonmetricTraits accessoryTransverseForaminaRight;

    // fields per zone type, not per bone ?
    @Nullable
    @Range(min = 0, max = 3)
    private Integer epiphysealUnionSuperior;

    @Nullable
    @Range(min = 0, max = 3)
    private Integer epiphysealUnionInferior;

    @Nullable
    @Range(min = 0, max = 4)
    private Integer osteophytosisSurfaceSuperior;

    @Nullable
    @Range(min = 0, max = 4)
    private Integer osteophytosisSurfaceInferior;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD osteophytosisInferiorLeftDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD osteophytosisInferiorRightDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD osteophytosisSuperiorLeftDJD;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD osteophytosisSuperiorRightDJD;

    @Nullable
    @Range(min = 0, max = 2)
    private Integer stageOfUnionNeuralArchesToEachOther;

    @Nullable
    @Range(min = 0, max = 2)
    private Integer stageOfUnionNeuralArchesToCentrum;
}
