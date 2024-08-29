package ro.ubb.abc2024.biology.service.teeth;

import ro.ubb.abc2024.biology.domain.teeth.Tooth;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;

public interface ToothService<T extends Tooth, D extends ToothDto> {
    T getById(Long id);
    T save(T tooth);
    T update(Long id, D dto);
    void delete(Long id);
}
