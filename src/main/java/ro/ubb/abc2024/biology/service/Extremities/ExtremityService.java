package ro.ubb.abc2024.biology.service.Extremities;

import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;

import java.util.List;

public interface ExtremityService {
    List<Extremity> getAll(EnumsBio.ExtremityBone extremityBone);
    Extremity getById(EnumsBio.ExtremityBone extremityBone, long id);
    Extremity save(Extremity service);
    Extremity update(EnumsBio.ExtremityBone extremityBone, Extremity extremity);
    void deleteById(EnumsBio.ExtremityBone extremityBone, long id);
}
