package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.Carpals;

import java.util.List;

public interface ICarpalsService {
    List<Carpals> getAllCarpals();
    Carpals getCarpalsById(Long id);
    Carpals saveCarpals(Carpals service);
    Carpals updateCarpals(Long id, Carpals carpals);
    void deleteCarpalsById(Long id);
}
