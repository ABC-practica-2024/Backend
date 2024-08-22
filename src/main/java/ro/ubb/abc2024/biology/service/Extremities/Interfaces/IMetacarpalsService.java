package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.Metacarpals;

import java.util.List;

public interface IMetacarpalsService {
     List<Metacarpals> getAllMetacarpals();
    Metacarpals getMetacarpalsById(Long id);
    Metacarpals saveMetacarpals(Metacarpals service);
    Metacarpals updateMetacarpals(Long id, Metacarpals metacarpals);
    void deleteMetacarpalsById(Long id);
}
