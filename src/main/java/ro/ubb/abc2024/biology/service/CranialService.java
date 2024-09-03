package ro.ubb.abc2024.biology.service;

import ro.ubb.abc2024.biology.domain.Cranial.Cranial;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.Cranial.CranialDto;

public interface CranialService {
    Cranial getById(EnumsBio.CranialBoneType cranialBoneType, Long id);

    Cranial save(EnumsBio.CranialBoneType cranialBoneType, Cranial cranialBone);

    Cranial update(EnumsBio.CranialBoneType cranialBoneType, CranialDto cranialBoneDto);

    void deleteById(EnumsBio.CranialBoneType cranialBoneType, Long id);
}
