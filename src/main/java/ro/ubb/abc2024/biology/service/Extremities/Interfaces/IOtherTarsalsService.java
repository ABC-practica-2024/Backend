package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.OtherTarsals;

import java.util.List;

public interface IOtherTarsalsService {
    List<OtherTarsals> getAllOtherTarsals();
    OtherTarsals getOtherTarsalsById(Long id);
    OtherTarsals saveOtherTarsals(OtherTarsals service);
    OtherTarsals updateOtherTarsals(Long id, OtherTarsals otherTarsals);
    void deleteOtherTarsalsById(Long id);
}
