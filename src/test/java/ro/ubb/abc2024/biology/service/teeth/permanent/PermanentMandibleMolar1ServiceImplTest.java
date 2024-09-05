package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar1Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleMolar1Repository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PermanentMandibleMolar1ServiceImplTest {

    @Mock
    private PermanentMandibleMolar1Repository repository;

    @Mock
    private PermanentMandibleMolar1Mapper mapper;

    @InjectMocks
    private PermanentMandibleMolar1ServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Positive test for save method
    @Test
    void testSave() {
        PermanentMandibleMolar1Dto dto = PermanentMandibleMolar1Dto.builder().build();
        PermanentMandibleMolar1 entity = new PermanentMandibleMolar1();

        // Mock behavior
        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);

        // Call the method under test
        PermanentMandibleMolar1 result = service.save(dto);

        // Verify the results
        assertNotNull(result);
        verify(mapper).toEntity(dto);
        verify(repository).save(entity);
    }

    // Negative test for save method (e.g., mapper throws an exception)
    @Test
    void testSaveThrowsException() {
        PermanentMandibleMolar1Dto dto = PermanentMandibleMolar1Dto.builder().build();

        // Mock behavior
        when(mapper.toEntity(dto)).thenThrow(new RuntimeException("Mapping error"));

        // Call the method under test and verify exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.save(dto));
        assertEquals("Mapping error", exception.getMessage());

        // Verify that save was not called due to the mapping error
        verify(repository, never()).save(any());
    }

    // Positive test for update method
    @Test
    void testUpdate() {
        Long id = 1L;
        PermanentMandibleMolar1Dto dto = PermanentMandibleMolar1Dto.builder().build();
        PermanentMandibleMolar1 existingEntity = new PermanentMandibleMolar1();

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.of(existingEntity));
        doNothing().when(mapper).updateEntityFromDto(dto, existingEntity);
        when(repository.save(existingEntity)).thenReturn(existingEntity);

        // Call the method under test
        PermanentMandibleMolar1 result = service.update(id, dto);

        // Verify the results
        assertNotNull(result);
        verify(repository).findById(id);
        verify(mapper).updateEntityFromDto(dto, existingEntity);
        verify(repository).save(existingEntity);
    }

    // Negative test for update method (entity not found)
    @Test
    void testUpdateThrowsEntityNotFoundException() {
        Long id = 1L;
        PermanentMandibleMolar1Dto dto = PermanentMandibleMolar1Dto.builder().build();

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Call the method under test and verify exception
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.update(id, dto));
        assertEquals("Entity not found with id " + id, exception.getMessage());
    }

    // Positive test for getById method
    @Test
    void testGetById() {
        Long id = 1L;
        PermanentMandibleMolar1 entity = new PermanentMandibleMolar1();

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        // Call the method under test
        PermanentMandibleMolar1 result = service.getById(id);

        // Verify the results
        assertNotNull(result);
        assertEquals(entity, result);
        verify(repository).findById(id);
    }

    // Negative test for getById method (entity not found)
    @Test
    void testGetByIdThrowsEntityNotFoundException() {
        Long id = 1L;

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Call the method under test and verify exception
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.getById(id));
        assertEquals("Entity not found with id " + id, exception.getMessage());
    }

    // Positive test for delete method
    @Test
    void testDelete() {
        Long id = 1L;

        // Mock behavior
        when(repository.existsById(id)).thenReturn(true);

        // Call the method under test
        service.delete(id);

        // Verify the results
        verify(repository).existsById(id);
        verify(repository).deleteById(id);
    }

    // Negative test for delete method (entity not found)
    @Test
    void testDeleteThrowsEntityNotFoundException() {
        Long id = 1L;

        // Mock behavior
        when(repository.existsById(id)).thenReturn(false);

        // Call the method under test and verify exception
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.delete(id));
        assertEquals("Entity not found with id " + id, exception.getMessage());

        // Verify that deleteById was not called due to the entity not being found
        verify(repository).existsById(id);
        verify(repository, never()).deleteById(id);
    }
}
