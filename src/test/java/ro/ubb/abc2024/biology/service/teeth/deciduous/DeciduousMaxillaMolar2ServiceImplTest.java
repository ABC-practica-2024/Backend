package ro.ubb.abc2024.biology.service.teeth.deciduous;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaMolar2Mapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaMolar2Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeciduousMaxillaMolar2ServiceImplTest {

    @Mock
    private DeciduousMaxillaMolar2Repository repository;

    @Mock
    private DeciduousMaxillaMolar2Mapper mapper;

    @InjectMocks
    private DeciduousMaxillaMolar2ServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        DeciduousMaxillaMolar2Dto dto = new DeciduousMaxillaMolar2Dto();
        DeciduousMaxillaMolar2 entity = new DeciduousMaxillaMolar2();

        // Mock behavior
        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);

        // Call the method under test
        DeciduousMaxillaMolar2 result = service.save(dto);

        // Verify the results
        assertNotNull(result);
        verify(mapper).toEntity(dto);
        verify(repository).save(entity);
    }

    @Test
    void testSaveThrowsException() {
        DeciduousMaxillaMolar2Dto dto = new DeciduousMaxillaMolar2Dto();

        // Mock behavior
        when(mapper.toEntity(dto)).thenThrow(new RuntimeException("Mapping error"));

        // Call the method under test and verify exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.save(dto));
        assertEquals("Mapping error", exception.getMessage());

        // Verify that save was not called due to the mapping error
        verify(repository, never()).save(any());
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        DeciduousMaxillaMolar2Dto dto = new DeciduousMaxillaMolar2Dto();
        DeciduousMaxillaMolar2 existingEntity = new DeciduousMaxillaMolar2();

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.of(existingEntity));
        doNothing().when(mapper).updateEntityFromDto(dto, existingEntity);
        when(repository.save(existingEntity)).thenReturn(existingEntity);

        // Call the method under test
        DeciduousMaxillaMolar2 result = service.update(id, dto);

        // Verify the results
        assertNotNull(result);
        verify(repository).findById(id);
        verify(mapper).updateEntityFromDto(dto, existingEntity);
        verify(repository).save(existingEntity);
    }

    @Test
    void testUpdateThrowsEntityNotFoundException() {
        Long id = 1L;
        DeciduousMaxillaMolar2Dto dto = new DeciduousMaxillaMolar2Dto();

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Call the method under test and verify exception
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.update(id, dto));
        assertEquals("Entity not found with id " + id, exception.getMessage());
    }

    @Test
    void testGetById() {
        Long id = 1L;
        DeciduousMaxillaMolar2 entity = new DeciduousMaxillaMolar2();

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        // Call the method under test
        DeciduousMaxillaMolar2 result = service.getById(id);

        // Verify the results
        assertNotNull(result);
        assertEquals(entity, result);
        verify(repository).findById(id);
    }

    @Test
    void testGetByIdThrowsEntityNotFoundException() {
        Long id = 1L;

        // Mock behavior
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Call the method under test and verify exception
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.getById(id));
        assertEquals("Entity not found with id " + id, exception.getMessage());
    }

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

    @Test
    void testGetAllByArtefactId() {
        UUID artefactId = UUID.randomUUID();
        List<DeciduousMaxillaMolar2> resultList = List.of(new DeciduousMaxillaMolar2());

        when(repository.getAllByArtefactId(artefactId)).thenReturn(resultList);

        List<DeciduousMaxillaMolar2> result = service.getAllByArtefactId(artefactId);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository).getAllByArtefactId(artefactId);
    }
}
