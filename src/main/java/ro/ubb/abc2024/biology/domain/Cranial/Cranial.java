package ro.ubb.abc2024.biology.domain.Cranial;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.ubb.abc2024.biology.domain.Bone;
import jakarta.annotation.Nullable;
import ro.ubb.abc2024.biology.domain.EnumsBio;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Cranial extends Bone {
    @Nullable
    @Enumerated(EnumType.STRING)
    private EnumsBio.CranialBoneType boneType;


}
