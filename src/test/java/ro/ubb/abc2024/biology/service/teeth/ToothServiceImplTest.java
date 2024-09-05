//package ro.ubb.abc2024.biology.service.teeth;
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import ro.ubb.abc2024.biology.domain.Tooth;
//import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleCanine;
//import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor1;
//import ro.ubb.abc2024.biology.dto.ToothDto;
//import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;
//import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleCanineRepository;
//import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleIncisor1Repository;
//
//import java.util.*;
//
//class ToothServiceImplTest {
//
//    @Mock
//    private PermanentMandibleCanineRepository permanentMandibleCanineRepository;
//
//    @Mock
//    private PermanentMandibleIncisor1Repository permanentMandibleIncisor1Repository;
//
//    @Mock
//    private ToothMapper mapper;
//
//    @InjectMocks
//    private ToothServiceImpl toothService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testSave() {
//        ToothDto dto = new ToothDto();
//        PermanentMandibleCanine tooth = new PermanentMandibleCanine();
//
//        when(mapper.toEntity(dto)).thenReturn(tooth);
//        when(permanentMandibleCanineRepository.save(tooth)).thenReturn(tooth);
//
//        Tooth savedTooth = toothService.save(dto);
//
//        assertNotNull(savedTooth);
//        verify(mapper).toEntity(dto);
//        verify(permanentMandibleCanineRepository).save(tooth);
//    }
//
//    @Test
//    void testUpdate() {
//        Long id = 1L;
//        ToothDto dto = new ToothDto();
//        PermanentMandibleCanine existingTooth = new PermanentMandibleCanine();
//        PermanentMandibleCanine updatedTooth = new PermanentMandibleCanine();
//
//        // Mock behavior
//        when(permanentMandibleCanineRepository.findById(id)).thenReturn(Optional.of(existingTooth));
//        when(mapper.updateEntityFromDto(dto, existingTooth)).thenReturn(existingTooth);
//        when(permanentMandibleCanineRepository.save(existingTooth)).thenReturn(updatedTooth);
//
//        // Call the update method
//        Tooth result = toothService.update(id, dto);
//
//        // Assertions
//        assertNotNull(result);
//        assertEquals(updatedTooth, result);
//        verify(mapper).updateEntityFromDto(dto, existingTooth);
//        verify(permanentMandibleCanineRepository).save(existingTooth);
//    }
//
//    @Test
//    void testGetAllByArtefactId() {
//        UUID artefactId = UUID.randomUUID();
//        List<PermanentMandibleCanine> canineList = Collections.singletonList(new PermanentMandibleCanine());
//        List<PermanentMandibleIncisor1> incisorList = Collections.singletonList(new PermanentMandibleIncisor1());
//
//        when(permanentMandibleCanineRepository.getAllByArtefactId(artefactId)).thenReturn(canineList);
//        when(permanentMandibleIncisor1Repository.getAllByArtefactId(artefactId)).thenReturn(incisorList);
//
//        // Make sure the service method calls the correct repository methods
//        List<Tooth> result = toothService.getAllByArtefactId(artefactId);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        verify(permanentMandibleCanineRepository).getAllByArtefactId(artefactId);
//        verify(permanentMandibleIncisor1Repository).getAllByArtefactId(artefactId);
//    }
//
//    @Test
//    void testSaveException() {
//        ToothDto dto = new ToothDto();
//        when(mapper.toEntity(dto)).thenThrow(new RuntimeException("Error"));
//
//        Exception exception = assertThrows(RuntimeException.class, () -> toothService.save(dto));
//
//        assertEquals("Error", exception.getMessage());
//    }
//
//    @Test
//    void testUpdateException() {
//        Long id = 1L;
//        ToothDto dto = new ToothDto();
//        when(permanentMandibleCanineRepository.findById(id)).thenThrow(new RuntimeException("Error"));
//
//        Exception exception = assertThrows(RuntimeException.class, () -> toothService.update(id, dto));
//
//        assertEquals("Error", exception.getMessage());
//    }
//}
