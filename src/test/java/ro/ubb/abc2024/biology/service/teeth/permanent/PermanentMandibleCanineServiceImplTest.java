package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleCanineMapper;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PermanentMandibleCanineServiceImplTest {

    @Mock
    private JpaRepository<PermanentMandibleCanine, Long> repository;

    @Mock
    private PermanentMandibleCanineMapper mapper;

    @InjectMocks
    private PermanentMandibleCanineServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Positive test for save method
    @Test
    void testSave() {
        PermanentMandibleCanineDto dto = new PermanentMandibleCanineDto();
        PermanentMandibleCanine entity = new PermanentMandibleCanine();

        // Mock behavior
        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);

        // Call the method under test
        PermanentMandibleCanine result = service.save(dto);

        // Verify the results
        assertNotNull(result);
        verify(mapper).toEntity(dto);
        verify(repository).save(entity);
    }

    // Negative test for save method (e.g., mapper throws an exception)
    @Test
    void testSaveThrowsException() {
        PermanentMandibleCanineDto dto = new PermanentMandibleCanineDto();

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
        PermanentMandibleCanineDto dto = new PermanentMandibleCanineDto();
        PermanentMandibleCanine existingEntity = new PermanentMandibleCanine();

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.of(existingEntity));
        doNothing().when(mapper).updateEntityFromDto(dto, existingEntity);
        when(repository.save(existingEntity)).thenReturn(existingEntity);

        // Call the method under test
        PermanentMandibleCanine result = service.update(id, dto);

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
        PermanentMandibleCanineDto dto = new PermanentMandibleCanineDto();

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
        PermanentMandibleCanine entity = new PermanentMandibleCanine();

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        // Call the method under test
        PermanentMandibleCanine result = service.getById(id);

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
