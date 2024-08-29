package ro.ubb.abc2024.biology.controller.teeth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface GenericToothController <T, D> {

    @GetMapping("/{id}")
    ResponseEntity<D> getById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<D> create(@RequestBody D dto);

    @PutMapping("/{id}")
    ResponseEntity<D> update(@PathVariable Long id, @RequestBody D dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

}