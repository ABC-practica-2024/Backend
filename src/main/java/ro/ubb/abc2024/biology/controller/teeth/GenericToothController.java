package ro.ubb.abc2024.biology.controller.teeth;

import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.utils.dto.Result;

public interface GenericToothController <T, D> {

    @GetMapping("/{id}")
    Result<D> getById(@PathVariable Long id);

    @PostMapping
    Result<D> create(@RequestBody D dto);

    @PutMapping("/{id}")
    Result<D> update(@PathVariable Long id, @RequestBody D dto);

    @DeleteMapping("/{id}")
    Result<Void> delete(@PathVariable Long id);

}