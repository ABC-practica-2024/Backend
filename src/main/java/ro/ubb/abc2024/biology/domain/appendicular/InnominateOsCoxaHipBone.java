package ro.ubb.abc2024.biology.domain.appendicular;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
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
public class InnominateOsCoxaHipBone extends Append {

    @Nullable
    private Double maxlengthAdult;

    @Nullable
    private Double apDiameterAdult;

    @Nullable
    private Double mlDiameterAdult;

    @Nullable
    private Double physiologicalLengthAdult;

    @Nullable
    private Double minCircumferenceAdult;

    @Nullable
    @Range(min=0, max=2)
    private Integer iliacCrestStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer iliacCrestAdultStageOfUnion;

    @Nullable
    @Range(min=0, max=2)
    private Integer ischialTuberosityStageOfUnion;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.InventoryCondition acetabulumInventoryCondition;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.StagesOfDJD acetabulumStageOfDJD;

}
