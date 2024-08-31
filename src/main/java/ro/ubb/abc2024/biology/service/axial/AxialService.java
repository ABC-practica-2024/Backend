package ro.ubb.abc2024.biology.service.axial;

import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.axial.Axial;
import ro.ubb.abc2024.biology.dto.axial.AxialDto;

public interface AxialService {
    Axial getById(EnumsBio.AxialBoneType axialBone, Long id);

    Axial save(EnumsBio.AxialBoneType axialBone, Axial axial);

    Axial update(EnumsBio.AxialBoneType axialBone, AxialDto axialDto);

    void deleteById(EnumsBio.AxialBoneType axialBone, Long id);
}
