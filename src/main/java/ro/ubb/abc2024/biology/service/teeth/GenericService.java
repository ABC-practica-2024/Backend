package ro.ubb.abc2024.biology.service.teeth;

public interface GenericService<T, D> {
    T getById(Long id);
    void delete(Long id);
}
