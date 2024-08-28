package ro.ubb.abc2024.biology.domain.teeth;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;
import ro.ubb.abc2024.biology.domain.BioLab;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Tooth extends BioLab {

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.ToothType toothType;

    @Nullable
    private Boolean isAdult;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.Side side;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.MaxilaMandible maxilaOrMandible;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition inventoryCondition;

    @Nullable
    @Range(min=0, max=9)
    private Integer inventory;

    @Nullable
    @Range(min=0, max=14)
    private Integer development;

    @Nullable
    @Range(min=0, max=7)
    private Integer caries;

    @Nullable
    @Range(min=0, max=2)
    private Integer abcesses;

    @Nullable
    @Range(min=0, max=3)
    private Integer calculus;

    @Nullable
    private Integer chipping;

    @Nullable
    @Range(min=1, max=8)
    private Integer attritionScoreIncisiv;

    @Nullable
    @Range(min=1, max=8)
    private Integer attritionScoreCanin;

    @Nullable
    @Range(min=1, max=8)
    private Integer attritionScorePreMolar;

    @Nullable
    @Range(min=1, max=10)
    private Integer attritionScoreMolar;

    @Nullable
    @Range(min=0, max=10)
    private Integer mesioBuccal;

    @Nullable
    @Range(min=0, max=10)
    private Integer mesioLingual;

    @Nullable
    @Range(min=0, max=10)
    private Integer distoLingual;

    @Nullable
    @Range(min=0, max=10)
    private Integer distoBuccal;

    @Nullable
    private Double mdDiameter;

    @Nullable
    private Double blDiameter;

    @Nullable
    private Double crownHeight;

    @Nullable
    private Integer defectNoOnTooth;

    @Nullable
    @Range(min=1, max=7)
    private Integer defectType;

    @Nullable
    private Double distanceFromCEJ;

    @Nullable
    @Range(min=1, max=4)
    private Integer color;

    @Nullable
    @Range(min=1, max=2)
    private Integer periodontitisAdult;

    @Nullable
    private Boolean toothHatch;

    @Nullable
    private String toothHatchDescription;

    @Nullable
    @Range(min=1, max=70)
    private Integer toothInventoryId;
}
