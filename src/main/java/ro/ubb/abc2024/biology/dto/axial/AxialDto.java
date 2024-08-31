package ro.ubb.abc2024.biology.dto.axial;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.BoneDto;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "boneType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CoccyxDto.class, name = "COCCYX"),
        @JsonSubTypes.Type(value = RibsDto.class, name = "RIBS"),
        @JsonSubTypes.Type(value = SacrumDto.class, name = "SACRUM"),
        @JsonSubTypes.Type(value = SternumDto.class, name = "STERNUM"),
        @JsonSubTypes.Type(value = VertebraeDto.class, name = "VERTEBRAE")
})
public class AxialDto extends BoneDto {

    @Nullable
    private EnumsBio.AxialBoneType boneType;

    @Nullable
    private EnumsBio.AxialBoneType axialBoneType;

    Boolean isWorking;
}
