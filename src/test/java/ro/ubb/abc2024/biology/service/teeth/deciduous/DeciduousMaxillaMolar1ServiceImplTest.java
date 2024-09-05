package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaMolar1Mapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaMolar1Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeciduousMaxillaMolar1ServiceImplTest {

    @Mock
    private DeciduousMaxillaMolar1Repository repository;

    @Mock
    private DeciduousMaxillaMolar1Mapper mapper;

    @InjectMocks
    private DeciduousMaxillaMolar1ServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        DeciduousMaxillaMolar1Dto dto = new DeciduousMaxillaMolar1Dto();
        DeciduousMaxillaMolar1 entity = new DeciduousMaxillaMolar1();

        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);

        DeciduousMaxillaMolar1 result = service.save(dto);

        assertNotNull(result);
        verify(mapper).toEntity(dto);
        verify(repository).save(entity);
    }

    @Test
    void testSaveThrowsException() {
        DeciduousMaxillaMolar1Dto dto = new DeciduousMaxillaMolar1Dto();

        when(mapper.toEntity(dto)).thenThrow(new RuntimeException("Mapping error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.save(dto));
        assertEquals("Mapping error", exception.getMessage());

        verify(repository, never()).save(any());
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        DeciduousMaxillaMolar1Dto dto = new DeciduousMaxillaMolar1Dto();
        DeciduousMaxillaMolar1 existingEntity = new DeciduousMaxillaMolar1();

        when(repository.findById(id)).thenReturn(Optional.of(existingEntity));
        doNothing().when(mapper).updateEntityFromDto(dto, existingEntity);
        when(repository.save(existingEntity)).thenReturn(existingEntity);

        DeciduousMaxillaMolar1 result = service.update(id, dto);

        assertNotNull(result);
        verify(repository).findById(id);
        verify(mapper).updateEntityFromDto(dto, existingEntity);
        verify(repository).save(existingEntity);
    }

    @Test
    void testUpdateThrowsEntityNotFoundException() {
        Long id = 1L;
        DeciduousMaxillaMolar1Dto dto = new DeciduousMaxillaMolar1Dto();

        when(repository.findById(id)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.update(id, dto));
        assertEquals("Entity not found with id " + id, exception.getMessage());
    }

    @Test
    void testGetById() {
        Long id = 1L;
        DeciduousMaxillaMolar1 entity = new DeciduousMaxillaMolar1();

        when(repository.findById(id)).thenReturn(Optional.of(entity));

        DeciduousMaxillaMolar1 result = service.getById(id);

        assertNotNull(result);
        assertEquals(entity, result);
        verify(repository).findById(id);
    }

    @Test
    void testGetByIdThrowsEntityNotFoundException() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.getById(id));
        assertEquals("Entity not found with id " + id, exception.getMessage());
    }

    @Test
    void testDelete() {
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(true);

        service.delete(id);

        verify(repository).existsById(id);
        verify(repository).deleteById(id);
    }

    @Test
    void testDeleteThrowsEntityNotFoundException() {
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(false);

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.delete(id));
        assertEquals("Entity not found with id " + id, exception.getMessage());

        verify(repository).existsById(id);
        verify(repository, never()).deleteById(id);
    }

    @Test
    void testGetAllByArtefactId() {
        UUID artefactId = UUID.randomUUID();
        List<DeciduousMaxillaMolar1> resultList = List.of(new DeciduousMaxillaMolar1());

        when(repository.getAllByArtefactId(artefactId)).thenReturn(resultList);

        List<DeciduousMaxillaMolar1> result = service.getAllByArtefactId(artefactId);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository).getAllByArtefactId(artefactId);
    }
}
