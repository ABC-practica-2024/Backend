package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.Phalanges;

import java.util.List;

public interface IPhalangesService {
    List<Phalanges> getAllPhalanges();
    Phalanges getPhalangesById(Long id);
    Phalanges savePhalanges(Phalanges service);
    Phalanges updatePhalanges(Long id, Phalanges phalanges);
    void deletePhalangesById(Long id);
}
