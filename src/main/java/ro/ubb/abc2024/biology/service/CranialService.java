package ro.ubb.abc2024.biology.service;

import ro.ubb.abc2024.biology.domain.Cranial.Cranial;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.Cranial.CranialDto;

public interface CranialService {
    Cranial getById(EnumsBio.CranialBoneAndTraits cranialBoneType, Long id);

    Cranial save(EnumsBio.CranialBoneAndTraits cranialBoneType, Cranial cranialBone);

    Cranial update(EnumsBio.CranialBoneAndTraits cranialBoneType, CranialDto cranialBoneDto);

    void deleteById(EnumsBio.CranialBoneAndTraits cranialBoneType, Long id);
}
