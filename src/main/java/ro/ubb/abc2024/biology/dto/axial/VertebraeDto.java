package ro.ubb.abc2024.biology.dto.axial;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class VertebraeDto extends AxialDto {

    @Nullable
    private EnumsBio.VertebraeZoneType vertebraeZoneType;

    @Nullable
    private EnumsBio.VertebraeType vertebraeType;

    @Nullable
    private Integer vertebraeNo;

    @Nullable
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private EnumsBio.NonmetricTraits accessoryTransverseForaminaLeft;

    @Nullable
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
    private EnumsBio.StagesOfDJD osteophytosisInferiorLeftDJD;

    @Nullable
    private EnumsBio.StagesOfDJD osteophytosisInferiorRightDJD;

    @Nullable
    private EnumsBio.StagesOfDJD osteophytosisSuperiorLeftDJD;

    @Nullable
    private EnumsBio.StagesOfDJD osteophytosisSuperiorRightDJD;

    @Nullable
    @Range(min = 0, max = 2)
    private Integer stageOfUnionNeuralArchesToEachOther;

    @Nullable
    @Range(min = 0, max = 2)
    private Integer stageOfUnionNeuralArchesToCentrum;
}
