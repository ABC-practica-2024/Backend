package ro.ubb.abc2024.biology.service.teeth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.teeth.Tooth;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ToothServiceImplTest {

    @Mock
    private JpaRepository<Tooth, Long> repository;

    @Mock
    private ToothMapper mapper;

    @InjectMocks
    private ToothServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        ToothDto dto = new ToothDto();
        Tooth entity = new Tooth();

        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);

        Tooth result = service.save(dto);

        assertNotNull(result);
        verify(mapper).toEntity(dto);
        verify(repository).save(entity);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        ToothDto dto = new ToothDto();
        Tooth existingEntity = new Tooth();

        when(repository.findById(id)).thenReturn(Optional.of(existingEntity));
        when(mapper.updateEntityFromDto(dto, existingEntity)).thenReturn(existingEntity);
        when(repository.save(existingEntity)).thenReturn(existingEntity);

        Tooth result = service.update(id, dto);

        assertNotNull(result);
        verify(repository).findById(id);
        verify(mapper).updateEntityFromDto(dto, existingEntity);
        verify(repository).save(existingEntity);
    }

    @Test
    void testGetByIdThrowsException() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> service.getById(id));
        assertEquals("Entity not found with id " + id, exception.getMessage());
    }

    @Test
    void testDelete() {
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> service.delete(id));
        verify(repository).existsById(id);
        verify(repository).deleteById(id);
    }

    @Test
    void testDeleteThrowsException() {
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(false);

        Exception exception = assertThrows(EntityNotFoundException.class, () -> service.delete(id));
        assertEquals("Entity not found with id " + id, exception.getMessage());
    }
}
