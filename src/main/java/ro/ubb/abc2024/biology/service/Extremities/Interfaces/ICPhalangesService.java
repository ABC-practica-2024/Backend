package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.CPhalanges;

import java.util.List;

public interface ICPhalangesService {
    List<CPhalanges> getAllCPhalanges();
    CPhalanges getCPhalangesById(Long id);
    CPhalanges saveCPhalanges(CPhalanges service);
    CPhalanges updateCPhalanges(Long id, CPhalanges cPhalanges);
    void deleteCPhalangesById(Long id);
}
