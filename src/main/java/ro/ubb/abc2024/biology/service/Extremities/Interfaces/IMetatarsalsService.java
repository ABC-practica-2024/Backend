package ro.ubb.abc2024.biology.service.Extremities.Interfaces;

import ro.ubb.abc2024.biology.domain.Extremities.Metatarsals;

import java.util.List;

public interface IMetatarsalsService {
    List<Metatarsals> getAllMetatarsals();
    Metatarsals getMetatarsalsById(Long id);
    Metatarsals saveMetatarsals(Metatarsals service);
    Metatarsals updateMetatarsals(Long id, Metatarsals metatarsals);
    void deleteMetatarsalsById(Long id);
}
