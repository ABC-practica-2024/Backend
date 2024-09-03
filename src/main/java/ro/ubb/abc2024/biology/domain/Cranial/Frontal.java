package ro.ubb.abc2024.biology.domain.Cranial;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Frontal extends Cranial {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;
    @Nullable
    @Min(1)
    @Max(5)
    private Integer supraorbitalMarginAdult;
    @Nullable
    @Min(1)
    @Max(5)
    private Integer glabellaAdult;
    @Nullable
    @Min(0)
    @Max(2)
    private Integer metopicSutureJuvenile;
    @Nullable
    private Double minimumFrontalBreadthAdult;
    @Nullable
    private Double frontalChordAdult;

}
