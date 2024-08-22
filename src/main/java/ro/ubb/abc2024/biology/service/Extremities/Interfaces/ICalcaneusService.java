package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.dto.Extremeties.CalcaneusDto;

import java.util.List;

public interface ICalcaneusService {
    List<Calcaneus> getAllCalcanei();
    Calcaneus getCalcaneusById(Long id);
    Calcaneus saveCalcaneus(Calcaneus service);
    Calcaneus updateCalcaneus(Long id, Calcaneus calcaneus);
    void deleteCalcaneusById(Long id);
}
