package ro.ubb.abc2024.biology.dto.Cranial;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.annotation.Nullable;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.BoneDto;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "boneType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EthmoidDto.class, name = "ETHMOID"),
        @JsonSubTypes.Type(value = FrontalDto.class, name = "FRONTAL"),
        @JsonSubTypes.Type(value = HyoidDto.class, name = "HYOID"),
        @JsonSubTypes.Type(value = InferiorNasalConchaDto.class, name = "INFERIOR_NASAL_CONCHA"),
        @JsonSubTypes.Type(value = LacrimalDto.class, name = "LACRIMAL"),
        @JsonSubTypes.Type(value = MandibleDto.class, name = "MANDIBLE"),
        @JsonSubTypes.Type(value = MaxillaDto.class, name = "MAXILLA"),
        @JsonSubTypes.Type(value = NasalDto.class, name = "NASAL"),
        @JsonSubTypes.Type(value = OccipitalDto.class, name = "OCCIPITAL"),
        @JsonSubTypes.Type(value = OssiclesDto.class, name = "OSSICLES"),
        @JsonSubTypes.Type(value = PalatineDto.class, name = "PALATINE"),
        @JsonSubTypes.Type(value = ParietalDto.class, name = "PARIETAL"),
        @JsonSubTypes.Type(value = SphenoidDto.class, name = "SPHENOID"),
        @JsonSubTypes.Type(value = TemporalDto.class, name = "TEMPORAL"),
        @JsonSubTypes.Type(value = ThyroidDto.class, name = "THYROID"),
        @JsonSubTypes.Type(value = TMJDto.class, name = "TMJ"),
        @JsonSubTypes.Type(value = VomerDto.class, name = "VOMER"),
        @JsonSubTypes.Type(value = ZygomaticDto.class, name = "ZYGOMATIC")

})
public class CranialDto extends BoneDto {
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.CranialBoneType boneType;

}
