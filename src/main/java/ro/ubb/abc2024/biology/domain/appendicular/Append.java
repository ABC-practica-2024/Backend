package ro.ubb.abc2024.biology.domain.appendicular;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Append extends Bone {

    @Enumerated(EnumType.STRING)
    private EnumsBio.AppendicularBoneType boneType;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.AppendicularBoneType appendicularBoneType;

}
