package ro.ubb.abc2024.biology.service.appendicular;

import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.appendicular.Append;
import ro.ubb.abc2024.biology.dto.appendicular.AppendDto;

public interface AppendService {
    Append getById(EnumsBio.AppendicularBoneType appendBone, Long id);

    Append save(EnumsBio.AppendicularBoneType appendBone, Append axial);

    Append update(EnumsBio.AppendicularBoneType appendBone, AppendDto appendDto);

    void deleteById(EnumsBio.AppendicularBoneType appendBone, Long id);

}
