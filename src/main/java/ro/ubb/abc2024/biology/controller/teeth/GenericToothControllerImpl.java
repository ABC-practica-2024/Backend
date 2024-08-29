package ro.ubb.abc2024.biology.controller.teeth;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;
import ro.ubb.abc2024.utils.dto.Result;

@RequiredArgsConstructor
public abstract class GenericToothControllerImpl<T, D> {

    private final SpecificToothService<T, D> service;

    @GetMapping("/{id}")
    public Result<D> getById(@PathVariable Long id) {
        T entity = service.getById(id);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        D dto = convertToDto(entity);
        return new Result<>(true, HttpStatus.OK.value(), "Entity retrieved successfully", dto);
    }

    @PostMapping
    public Result<D> create(@RequestBody D dto) {
        try {
            T entity = service.save(dto);
            D responseDto = convertToDto(entity);
            return new Result<>(true, HttpStatus.CREATED.value(), "Entity created successfully", responseDto);
        } catch (Exception e) {
            return new Result<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred");
        }
    }

    @PutMapping("/{id}")
    public Result<D> update(@PathVariable Long id, @RequestBody D dto) {
        T entity = service.update(id, dto);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        D responseDto = convertToDto(entity);
        return new Result<>(true, HttpStatus.OK.value(), "Entity updated successfully", responseDto);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        T entity = service.getById(id);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        service.delete(id);
        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Entity deleted successfully");
    }

    protected abstract D convertToDto(T entity);
}