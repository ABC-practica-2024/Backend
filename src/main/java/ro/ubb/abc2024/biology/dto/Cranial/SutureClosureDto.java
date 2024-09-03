package ro.ubb.abc2024.biology.dto.Cranial;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.dto.BioLabDto;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SutureClosureDto extends BioLabDto {
    @Nullable
    @Min(0)
    @Max(3)
    private Integer midlambdoidSutureClosure;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer lambda;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer obelion;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer anteriorSagittal;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer bregma;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer midcoronal;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer pterion;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer sphenofrontal;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer infSphenotemporal;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer supSphenotemporal;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer incisiveSuture;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer anteriorMedian;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer posteriorMedian;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer transversePalatine;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer sagittal;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer leftLambdoid;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer leftCoronal;

    @Nullable
    @Min(0)
    @Max(2)
    private Integer basilarSuture;

}
