package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.TPhalanges;

import java.util.List;

public interface ITPhalangesService {
    List<TPhalanges> getAllTPhalanges();
    TPhalanges getTPhalangesById(Long id);
    TPhalanges saveTPhalanges(TPhalanges service);
    TPhalanges updateTPhalanges(Long id, TPhalanges tPhalanges);
    void deleteTPhalangesById(Long id);
}
