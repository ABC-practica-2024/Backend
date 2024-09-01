package ro.ubb.abc2024.biology.dto.appendicular;

import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class IschiumDto extends AppendDto {

    @Nullable
    private Double length;

    @Nullable
    private Double width;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    @Range(min=0, max=2)
    private Integer ischiumPubisStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer ischiumIliumStageOfUnion;

}
