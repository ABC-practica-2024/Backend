package ro.ubb.abc2024.biology.service.teeth;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.Tooth;

@RequiredArgsConstructor
public abstract class GenericServiceImpl<T extends Tooth, D> implements GenericService<T, D> {

    protected final JpaRepository<T, Long> repository;

    @Override
    public T getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found with id " + id);
        }
        repository.deleteById(id);
    }


}
