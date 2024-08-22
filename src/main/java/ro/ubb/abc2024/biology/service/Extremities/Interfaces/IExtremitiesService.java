package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.Extremities;
import java.util.List;

public interface IExtremitiesService {
    List<Extremities> getAllExtremities();
    Extremities getExtremitiesById(Long id);
    Extremities saveExtremities(Extremities service);
    Extremities updateExtremities(Long id, Extremities extremity);
    void deleteExtremitiesById(Long id);
}
