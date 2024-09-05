package ro.ubb.abc2024.biology.service.teeth;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

public interface SpecificToothService<T, D> extends GenericService<T, D> {
    @Transactional
    T save(D dto);

    @Transactional
    T update(Long id, D dto);

    List<T> getAllByArtefactId(UUID artefactId);
}
