package ro.ubb.abc2024.biology.dto.appendicular;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.annotation.Nullable;
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
        @JsonSubTypes.Type(value = ClavicleDto.class, name = "CLAVICLE"),
        @JsonSubTypes.Type(value = FemurDto.class, name = "FEMUR"),
        @JsonSubTypes.Type(value = FibulaDto.class, name = "FIBULA"),
        @JsonSubTypes.Type(value = HumerusDto.class, name = "HUMERUS"),
        @JsonSubTypes.Type(value = IliumDto.class, name = "ILIUM"),
        @JsonSubTypes.Type(value = InnominateOsCoxaHipBoneDto.class, name = "OSCOXA"),
        @JsonSubTypes.Type(value = IschiumDto.class, name = "ISCHIUM"),
        @JsonSubTypes.Type(value = PatellaDto.class, name = "PATELLA"),
        @JsonSubTypes.Type(value = PubisDto.class, name = "PUBIS"),
        @JsonSubTypes.Type(value = RadiusDto.class, name = "RADIUS"),
        @JsonSubTypes.Type(value = ScapulaDto.class, name = "SCAPULA"),
        @JsonSubTypes.Type(value = TibiaDto.class, name = "TIBIA"),
        @JsonSubTypes.Type(value = UlnaDto.class, name = "ULNA")
})
public class AppendDto extends BoneDto {

    @Nullable
    private EnumsBio.AppendicularBoneType boneType;

    @Nullable
    private EnumsBio.AppendicularBoneType appendicularBoneType;

}
