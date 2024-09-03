package ro.ubb.abc2024.biology.service.Extremities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.ExtremityRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ExtremityServiceImplTest {

    @Mock
    private ExtremityRepository extremityRepository;

    @InjectMocks
    private ExtremityServiceImpl extremityService;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }



    @Test
    void save_Calcaneus_Success() {
        Calcaneus calcaneus = Calcaneus.builder()
                .maxLength(10.0)
                .middleBreadth(5.0)
                .stagesOfDJD(EnumsBio.StagesOfDJD.E)
                .build();

        when(extremityRepository.save(calcaneus)).thenReturn(calcaneus);

        Calcaneus result = (Calcaneus) extremityService.save(calcaneus);

        assertNotNull(result);
        assertEquals(10.0, result.getMaxLength());
        assertEquals(EnumsBio.StagesOfDJD.E, result.getStagesOfDJD());
        verify(extremityRepository, times(1)).save(calcaneus);
    }

    @Test
    void save_Carpals_Success() {
        Carpals carpals = Carpals.builder()
                .stagesOfDJD(EnumsBio.StagesOfDJD.A)
                .build();

        when(extremityRepository.save(carpals)).thenReturn(carpals);

        Carpals result = (Carpals) extremityService.save(carpals);

        assertNotNull(result);
        assertEquals(EnumsBio.StagesOfDJD.A, result.getStagesOfDJD());
        verify(extremityRepository, times(1)).save(carpals);
    }

    @Test
    void save_UnexpectedValue_ThrowsException() {
        Extremity unknownExtremity = mock(Extremity.class);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            extremityService.save(unknownExtremity);
        });

        assertEquals("Unexpected value: " + unknownExtremity, exception.getMessage());
    }

    @Test
    void testGetAllCalcaneus() {
        Calcaneus calcaneus = Calcaneus.builder().maxLength(5.0).middleBreadth(2.0).build();
        List<Calcaneus> calcaneusList = List.of(calcaneus);

        when(extremityRepository.getAllCalcaneus()).thenReturn(calcaneusList);

        List<Extremity> result = extremityService.getAll(EnumsBio.ExtremityBone.CALCANEUS);

        assertEquals(1, result.size());
        assertEquals(calcaneusList, result);
    }

    @Test
    void testGetAllCarpals() {

        Carpals carpals = Carpals.builder().build();
        List<Carpals> carpalsList = List.of(carpals);

        when(extremityRepository.getAllCarpals()).thenReturn(carpalsList);

        List<Extremity> result = extremityService.getAll(EnumsBio.ExtremityBone.SCAPHOID);

        assertEquals(1, result.size());
        assertEquals(carpalsList, result);
    }

    @Test
    void testGetById_CalcaneusFound() {
        long id = 1L;
        Calcaneus calcaneus = new Calcaneus();
        when(extremityRepository.getCalcaneusById(id)).thenReturn(Optional.of(calcaneus));

        Extremity result = extremityService.getById(EnumsBio.ExtremityBone.CALCANEUS, id);

        assertNotNull(result);
        assertEquals(calcaneus, result);
        verify(extremityRepository, times(1)).getCalcaneusById(id);
    }

    @Test
    void testGetById_CalcaneusNotFound() {

        long id = 1L;
        when(extremityRepository.getCalcaneusById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            extremityService.getById(EnumsBio.ExtremityBone.CALCANEUS, id);
        });

        String expectedMessage = "Calcaneus not found with id: " + id;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(extremityRepository, times(1)).getCalcaneusById(id);
    }

    @Test
    void testGetById_CarpalsFound() {

        long id = 1L;
        Carpals carpals = new Carpals();
        when(extremityRepository.getCarpalsById(id)).thenReturn(Optional.of(carpals));

        Extremity result = extremityService.getById(EnumsBio.ExtremityBone.SCAPHOID, id);

        assertNotNull(result);
        assertEquals(carpals, result);
        verify(extremityRepository, times(1)).getCarpalsById(id);
    }

    @Test
    void testGetById_CarpalsNotFound() {
        long id = 1L;
        when(extremityRepository.getCarpalsById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            extremityService.getById(EnumsBio.ExtremityBone.SCAPHOID, id);
        });

        String expectedMessage = "Carpals not found with id: " + id;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(extremityRepository, times(1)).getCarpalsById(id);
    }

    @Test
    void update_Calcaneus_ShouldUpdateAndSave() {
        long id = 1L;
        Calcaneus existingCalcaneus = new Calcaneus();
        existingCalcaneus.setId(id);
        existingCalcaneus.setMaxLength(10.0);
        existingCalcaneus.setMiddleBreadth(5.0);
        existingCalcaneus.setStagesOfDJD(EnumsBio.StagesOfDJD.A);

        Calcaneus updatedCalcaneus = new Calcaneus();
        updatedCalcaneus.setId(id);
        updatedCalcaneus.setMaxLength(12.0);
        updatedCalcaneus.setMiddleBreadth(6.0);
        updatedCalcaneus.setStagesOfDJD(EnumsBio.StagesOfDJD.B);

        when(extremityRepository.getCalcaneusById(id)).thenReturn(Optional.of(existingCalcaneus));
        when(extremityRepository.save(any(Calcaneus.class))).thenReturn(updatedCalcaneus);

        Calcaneus result = (Calcaneus) extremityService.update(EnumsBio.ExtremityBone.CALCANEUS, updatedCalcaneus);

        assertNotNull(result);
        assertEquals(12.0, result.getMaxLength());
        assertEquals(6.0, result.getMiddleBreadth());
        assertEquals(EnumsBio.StagesOfDJD.B, result.getStagesOfDJD());
        verify(extremityRepository).save(existingCalcaneus);
    }

    @Test
    void update_Carpals_ShouldUpdateAndSave() {
        long id = 2L;
        Carpals existingCarpals = new Carpals();
        existingCarpals.setId(id);
        existingCarpals.setStagesOfDJD(EnumsBio.StagesOfDJD.A);

        Carpals updatedCarpals = new Carpals();
        updatedCarpals.setId(id);
        updatedCarpals.setStagesOfDJD(EnumsBio.StagesOfDJD.C);

        when(extremityRepository.getCarpalsById(id)).thenReturn(Optional.of(existingCarpals));
        when(extremityRepository.save(any(Carpals.class))).thenReturn(updatedCarpals);

        Carpals result = (Carpals) extremityService.update(EnumsBio.ExtremityBone.SCAPHOID, updatedCarpals);

        assertNotNull(result);
        assertEquals(EnumsBio.StagesOfDJD.C, result.getStagesOfDJD());
        verify(extremityRepository).save(existingCarpals);
    }

    @Test
    void getById_Calcaneus_ShouldThrowExceptionWhenNotFound() {
        long id = 4L;
        when(extremityRepository.getCalcaneusById(id)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () ->
                extremityService.getById(EnumsBio.ExtremityBone.CALCANEUS, id)
        );
        assertEquals("Calcaneus not found with id: 4", thrown.getMessage());
    }


    @Test
    void testDeleteCalcaneusById_success() {
        long id = 1L;
        Calcaneus calcaneus = new Calcaneus();
        when(extremityRepository.getCalcaneusById(id)).thenReturn(Optional.of(calcaneus));

        extremityService.deleteById(EnumsBio.ExtremityBone.CALCANEUS, id);

        verify(extremityRepository, times(1)).delete(calcaneus);
    }

    @Test
    void testDeleteCalcaneusById_notFound() {
        long id = 1L;
        when(extremityRepository.getCalcaneusById(id)).thenReturn(Optional.empty());

        ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class, () ->
                extremityService.deleteById(EnumsBio.ExtremityBone.CALCANEUS, id)
        );
        assertEquals("Calcaneus with ID = 1 not found", thrown.getMessage());
    }

    @Test
    void testDeleteCarpalsById_success() {
        long id = 1L;
        Carpals carpals = new Carpals();
        when(extremityRepository.getCarpalsById(id)).thenReturn(Optional.of(carpals));

        extremityService.deleteById(EnumsBio.ExtremityBone.SCAPHOID, id);

        verify(extremityRepository, times(1)).delete(carpals);
    }

    @Test
    void testDeleteCarpalsById_notFound() {
        long id = 1L;
        when(extremityRepository.getCarpalsById(id)).thenReturn(Optional.empty());

        ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class, () ->
                extremityService.deleteById(EnumsBio.ExtremityBone.SCAPHOID, id)
        );
        assertEquals("Carpals with ID = 1 not found", thrown.getMessage());
    }


}
