package ro.ubb.abc2024.biology.dto.Cranial;

import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TemporalDto extends CranialDto {
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    private Double petrousPortionLengthJuvenile;

    @Nullable
    private Double petrousPortionWidthJuvenile;

    @Nullable
    @Min(1)
    @Max(5)
    private Integer mastoidProcessAdult;

    @Nullable
    private Double mastoidLengthAdult;

    @Nullable
    private Double biauricularBreadthAdult;

}
