package ro.ubb.abc2024.biology.service.axial;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.axial.*;
import ro.ubb.abc2024.biology.dto.axial.*;
import ro.ubb.abc2024.biology.mapper.axial.*;
import ro.ubb.abc2024.biology.repository.axial.AxialRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AxialServiceImplTest {

    @Mock
    private AxialRepository axialRepository;

    @InjectMocks
    private AxialServiceImpl axialService;
    @Mock
    private CoccyxMapper coccyxMapper;

    @Mock
    private RibsMapper ribsMapper;

    @Mock
    private SacrumMapper sacrumMapper;

    @Mock
    private SternumMapper sternumMapper;

    @Mock
    private VertebraeMapper vertebraeMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Tests for COCCYX retrieval
    @Test
    void testGetCoccyxById() {
        Coccyx coccyx = new Coccyx();
        when(axialRepository.getCoccyxById(1L)).thenReturn(java.util.Optional.of(coccyx));

        Axial result = axialService.getById(EnumsBio.AxialBoneType.COCCYX, 1L);

        assertEquals(coccyx, result);
        verify(axialRepository).getCoccyxById(1L);
    }

    @Test
    void testGetCoccyxByIdNotFound() {
        when(axialRepository.getCoccyxById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                axialService.getById(EnumsBio.AxialBoneType.COCCYX, 1L)
        );

        verify(axialRepository).getCoccyxById(1L);
    }

    // Tests for RIBS retrieval
    @Test
    void testGetRibsById() {
        Ribs ribs = new Ribs();
        when(axialRepository.getRibsById(2L)).thenReturn(java.util.Optional.of(ribs));

        Axial result = axialService.getById(EnumsBio.AxialBoneType.RIBS, 2L);

        assertEquals(ribs, result);
        verify(axialRepository).getRibsById(2L);
    }

    @Test
    void testGetRibsByIdNotFound() {
        when(axialRepository.getRibsById(2L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                axialService.getById(EnumsBio.AxialBoneType.RIBS, 2L)
        );

        verify(axialRepository).getRibsById(2L);
    }

    // Tests for SACRUM retrieval
    @Test
    void testGetSacrumById() {
        Sacrum sacrum = new Sacrum();
        when(axialRepository.getSacrumById(3L)).thenReturn(java.util.Optional.of(sacrum));

        Axial result = axialService.getById(EnumsBio.AxialBoneType.SACRUM, 3L);

        assertEquals(sacrum, result);
        verify(axialRepository).getSacrumById(3L);
    }

    @Test
    void testGetSacrumByIdNotFound() {
        when(axialRepository.getSacrumById(3L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                axialService.getById(EnumsBio.AxialBoneType.SACRUM, 3L)
        );

        verify(axialRepository).getSacrumById(3L);
    }

    // Tests for STERNUM retrieval
    @Test
    void testGetSternumById() {
        Sternum sternum = new Sternum();
        when(axialRepository.getSternumById(4L)).thenReturn(java.util.Optional.of(sternum));

        Axial result = axialService.getById(EnumsBio.AxialBoneType.STERNUM, 4L);

        assertEquals(sternum, result);
        verify(axialRepository).getSternumById(4L);
    }

    @Test
    void testGetSternumByIdNotFound() {
        when(axialRepository.getSternumById(4L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                axialService.getById(EnumsBio.AxialBoneType.STERNUM, 4L)
        );

        verify(axialRepository).getSternumById(4L);
    }

    // Tests for VERTEBRAE retrieval
    @Test
    void testGetVertebraeById() {
        Vertebrae vertebrae = new Vertebrae();
        when(axialRepository.getVertebraeById(5L)).thenReturn(java.util.Optional.of(vertebrae));

        Axial result = axialService.getById(EnumsBio.AxialBoneType.VERTEBRAE, 5L);

        assertEquals(vertebrae, result);
        verify(axialRepository).getVertebraeById(5L);
    }

    @Test
    void testGetVertebraeByIdNotFound() {
        when(axialRepository.getVertebraeById(5L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                axialService.getById(EnumsBio.AxialBoneType.VERTEBRAE, 5L)
        );

        verify(axialRepository).getVertebraeById(5L);
    }

    // Tests for saving COCCYX
    @Test
    void testSaveCoccyx() {
        Coccyx coccyx = new Coccyx();
        when(axialRepository.save(coccyx)).thenReturn(coccyx);

        Axial result = axialService.save(EnumsBio.AxialBoneType.COCCYX, coccyx);

        assertEquals(coccyx, result);
        verify(axialRepository).save(coccyx);
    }

    @Test
    void testSaveCoccyxWithInvalidType() {
        Sacrum sacrum = new Sacrum();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                axialService.save(EnumsBio.AxialBoneType.COCCYX, sacrum)
        );

        assertEquals("Expected an instance of Coccyx for COCCYX.", exception.getMessage());
        verify(axialRepository, never()).save(any());
    }

    // Tests for saving RIBS
    @Test
    void testSaveRibs() {
        Ribs ribs = new Ribs();
        when(axialRepository.save(ribs)).thenReturn(ribs);

        Axial result = axialService.save(EnumsBio.AxialBoneType.RIBS, ribs);

        assertEquals(ribs, result);
        verify(axialRepository).save(ribs);
    }

    @Test
    void testSaveRibsWithInvalidType() {
        Coccyx coccyx = new Coccyx();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                axialService.save(EnumsBio.AxialBoneType.RIBS, coccyx)
        );

        assertEquals("Expected an instance of Ribs for RIBS.", exception.getMessage());
        verify(axialRepository, never()).save(any());
    }

    // Tests for saving SACRUM
    @Test
    void testSaveSacrum() {
        Sacrum sacrum = new Sacrum();
        when(axialRepository.save(sacrum)).thenReturn(sacrum);

        Axial result = axialService.save(EnumsBio.AxialBoneType.SACRUM, sacrum);

        assertEquals(sacrum, result);
        verify(axialRepository).save(sacrum);
    }

    @Test
    void testSaveSacrumWithInvalidType() {
        Sternum sternum = new Sternum();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                axialService.save(EnumsBio.AxialBoneType.SACRUM, sternum)
        );

        assertEquals("Expected an instance of Sacrum for SACRUM.", exception.getMessage());
        verify(axialRepository, never()).save(any());
    }

    // Tests for saving STERNUM
    @Test
    void testSaveSternum() {
        Sternum sternum = new Sternum();
        when(axialRepository.save(sternum)).thenReturn(sternum);

        Axial result = axialService.save(EnumsBio.AxialBoneType.STERNUM, sternum);

        assertEquals(sternum, result);
        verify(axialRepository).save(sternum);
    }

    @Test
    void testSaveSternumWithInvalidType() {
        Vertebrae vertebrae = new Vertebrae();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                axialService.save(EnumsBio.AxialBoneType.STERNUM, vertebrae)
        );

        assertEquals("Expected an instance of Sternum for STERNUM.", exception.getMessage());
        verify(axialRepository, never()).save(any());
    }

    // Tests for saving VERTEBRAE
    @Test
    void testSaveVertebrae() {
        Vertebrae vertebrae = new Vertebrae();
        when(axialRepository.save(vertebrae)).thenReturn(vertebrae);

        Axial result = axialService.save(EnumsBio.AxialBoneType.VERTEBRAE, vertebrae);

        assertEquals(vertebrae, result);
        verify(axialRepository).save(vertebrae);
    }

    @Test
    void testSaveVertebraeWithInvalidType() {
        Ribs ribs = new Ribs();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                axialService.save(EnumsBio.AxialBoneType.VERTEBRAE, ribs)
        );

        assertEquals("Expected an instance of Vertebrae for VERTEBRAE.", exception.getMessage());
        verify(axialRepository, never()).save(any());
    }

    // Tests for null Axial entity
    @Test
    void testSaveWithNullEntity() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                axialService.save(EnumsBio.AxialBoneType.COCCYX, null)
        );

        assertEquals("The entity to be saved cannot be null.", exception.getMessage());
        verify(axialRepository, never()).save(any());
    }

    // Test for unexpected axialBone value
    @Test
    void testSaveWithUnexpectedAxialBoneType() {
        // Given a valid Sacrum entity and a null axialBone type
        Sacrum sacrum = new Sacrum();

        // When save is called with a null axialBone type, we expect an IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                axialService.save(EnumsBio.AxialBoneType.RIBS, sacrum)
        );

        // Then the exception message should be as expected
        assertEquals("Expected an instance of Ribs for RIBS.", exception.getMessage());
    }

    // Tests for updating COCCYX
    @Test
    void testUpdateCoccyx() {
        CoccyxDto coccyxDto = new CoccyxDto();
        coccyxDto.setId(1L);
        Coccyx coccyx = new Coccyx();

        when(axialRepository.getCoccyxById(coccyxDto.getId())).thenReturn(java.util.Optional.of(coccyx));
        when(axialRepository.save(coccyx)).thenReturn(coccyx);

        Axial result = axialService.update(EnumsBio.AxialBoneType.COCCYX, coccyxDto);

        assertEquals(coccyx, result);
        verify(coccyxMapper).updateEntityFromDto(coccyxDto, coccyx);
        verify(axialRepository).save(coccyx);
    }

    @Test
    void testUpdateCoccyxEntityNotFound() {
        CoccyxDto coccyxDto = new CoccyxDto();
        coccyxDto.setId(1L);

        when(axialRepository.getCoccyxById(coccyxDto.getId())).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.update(EnumsBio.AxialBoneType.COCCYX, coccyxDto)
        );

        assertEquals("Coccyx not found with id: 1", exception.getMessage());
    }

    // Tests for updating RIBS
    @Test
    void testUpdateRibs() {
        RibsDto ribsDto = new RibsDto();
        ribsDto.setId(1L);
        Ribs ribs = new Ribs();

        when(axialRepository.getRibsById(ribsDto.getId())).thenReturn(java.util.Optional.of(ribs));
        when(axialRepository.save(ribs)).thenReturn(ribs);

        Axial result = axialService.update(EnumsBio.AxialBoneType.RIBS, ribsDto);

        assertEquals(ribs, result);
        verify(ribsMapper).updateEntityFromDto(ribsDto, ribs);
        verify(axialRepository).save(ribs);
    }

    @Test
    void testUpdateRibsEntityNotFound() {
        RibsDto ribsDto = new RibsDto();
        ribsDto.setId(1L);

        when(axialRepository.getRibsById(ribsDto.getId())).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.update(EnumsBio.AxialBoneType.RIBS, ribsDto)
        );

        assertEquals("Ribs not found with id: 1", exception.getMessage());
    }


    // Test for SACRUM
    @Test
    void testUpdateSacrum() {
        SacrumDto sacrumDto = new SacrumDto();
        sacrumDto.setId(1L);
        Sacrum sacrum = new Sacrum();

        when(axialRepository.getSacrumById(sacrumDto.getId())).thenReturn(java.util.Optional.of(sacrum));
        when(axialRepository.save(sacrum)).thenReturn(sacrum);

        Axial result = axialService.update(EnumsBio.AxialBoneType.SACRUM, sacrumDto);

        assertEquals(sacrum, result);
        verify(sacrumMapper).updateEntityFromDto(sacrumDto, sacrum);
        verify(axialRepository).save(sacrum);
    }

    @Test
    void testUpdateSacrumEntityNotFound() {
        SacrumDto sacrumDto = new SacrumDto();
        sacrumDto.setId(1L);

        when(axialRepository.getSacrumById(sacrumDto.getId())).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.update(EnumsBio.AxialBoneType.SACRUM, sacrumDto)
        );

        assertEquals("Sacrum not found with id: 1", exception.getMessage());
    }

    // Test for STERNUM
    @Test
    void testUpdateSternum() {
        SternumDto sternumDto = new SternumDto();
        sternumDto.setId(1L);
        Sternum sternum = new Sternum();

        when(axialRepository.getSternumById(sternumDto.getId())).thenReturn(java.util.Optional.of(sternum));
        when(axialRepository.save(sternum)).thenReturn(sternum);

        Axial result = axialService.update(EnumsBio.AxialBoneType.STERNUM, sternumDto);

        assertEquals(sternum, result);
        verify(sternumMapper).updateEntityFromDto(sternumDto, sternum);
        verify(axialRepository).save(sternum);
    }

    @Test
    void testUpdateSternumEntityNotFound() {
        SternumDto sternumDto = new SternumDto();
        sternumDto.setId(1L);

        when(axialRepository.getSternumById(sternumDto.getId())).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.update(EnumsBio.AxialBoneType.STERNUM, sternumDto)
        );

        assertEquals("Sternum not found with id: 1", exception.getMessage());
    }

    // Test for VERTEBRAE
    @Test
    void testUpdateVertebrae() {
        VertebraeDto vertebraeDto = new VertebraeDto();
        vertebraeDto.setId(1L);
        Vertebrae vertebrae = new Vertebrae();

        when(axialRepository.getVertebraeById(vertebraeDto.getId())).thenReturn(java.util.Optional.of(vertebrae));
        when(axialRepository.save(vertebrae)).thenReturn(vertebrae);

        Axial result = axialService.update(EnumsBio.AxialBoneType.VERTEBRAE, vertebraeDto);

        assertEquals(vertebrae, result);
        verify(vertebraeMapper).updateEntityFromDto(vertebraeDto, vertebrae);
        verify(axialRepository).save(vertebrae);
    }

    @Test
    void testUpdateVertebraeEntityNotFound() {
        VertebraeDto vertebraeDto = new VertebraeDto();
        vertebraeDto.setId(1L);

        when(axialRepository.getVertebraeById(vertebraeDto.getId())).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.update(EnumsBio.AxialBoneType.VERTEBRAE, vertebraeDto)
        );

        assertEquals("Vertebrae not found with id: 1", exception.getMessage());
    }

    // Null AxialDto Test
    @Test
    void testUpdateWithNullDto() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                axialService.update(EnumsBio.AxialBoneType.COCCYX, null)
        );

        assertEquals("AxialDto cannot be null", exception.getMessage());
    }

    // Tests for deleting COCCYX
    @Test
    void testDeleteByIdCoccyxSuccess() {
        Coccyx coccyx = new Coccyx();
        when(axialRepository.getCoccyxById(anyLong())).thenReturn(java.util.Optional.of(coccyx));

        assertDoesNotThrow(() -> axialService.deleteById(EnumsBio.AxialBoneType.COCCYX, 1L));
        verify(axialRepository).delete(coccyx);
    }

    @Test
    void testDeleteByIdCoccyxNotFound() {
        when(axialRepository.getCoccyxById(anyLong())).thenReturn(java.util.Optional.empty());

        EntityNotFoundException thrown = assertThrows(EntityNotFoundException.class, () ->
                axialService.deleteById(EnumsBio.AxialBoneType.COCCYX, 1L)
        );
        assertEquals("Coccyx not found with id: 1", thrown.getMessage());
    }

    // Tests for deleting RIBS
    @Test
    void testDeleteRibs() {
        Ribs ribs = new Ribs();
        ribs.setId(2L);

        when(axialRepository.getRibsById(2L)).thenReturn(java.util.Optional.of(ribs));

        axialService.deleteById(EnumsBio.AxialBoneType.RIBS, 2L);

        verify(axialRepository).delete(ribs);
    }

    @Test
    void testDeleteRibsEntityNotFound() {
        when(axialRepository.getRibsById(2L)).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.deleteById(EnumsBio.AxialBoneType.RIBS, 2L)
        );

        assertEquals("Ribs not found with id: 2", exception.getMessage());
        verify(axialRepository, never()).delete(any());
    }

    // Tests for deleting SACRUM
    @Test
    void testDeleteSacrum() {
        Sacrum sacrum = new Sacrum();
        sacrum.setId(3L);

        when(axialRepository.getSacrumById(3L)).thenReturn(java.util.Optional.of(sacrum));

        axialService.deleteById(EnumsBio.AxialBoneType.SACRUM, 3L);

        verify(axialRepository).delete(sacrum);
    }

    @Test
    void testDeleteSacrumEntityNotFound() {
        when(axialRepository.getSacrumById(3L)).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.deleteById(EnumsBio.AxialBoneType.SACRUM, 3L)
        );

        assertEquals("Sacrum not found with id: 3", exception.getMessage());
        verify(axialRepository, never()).delete(any());
    }

    // Tests for deleting STERNUM
    @Test
    void testDeleteSternum() {
        Sternum sternum = new Sternum();
        sternum.setId(4L);

        when(axialRepository.getSternumById(4L)).thenReturn(java.util.Optional.of(sternum));

        axialService.deleteById(EnumsBio.AxialBoneType.STERNUM, 4L);

        verify(axialRepository).delete(sternum);
    }

    @Test
    void testDeleteSternumEntityNotFound() {
        when(axialRepository.getSternumById(4L)).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.deleteById(EnumsBio.AxialBoneType.STERNUM, 4L)
        );

        assertEquals("Sternum not found with id: 4", exception.getMessage());
        verify(axialRepository, never()).delete(any());
    }

    // Tests for deleting VERTEBRAE
    @Test
    void testDeleteVertebrae() {
        Vertebrae vertebrae = new Vertebrae();
        vertebrae.setId(5L);

        when(axialRepository.getVertebraeById(5L)).thenReturn(java.util.Optional.of(vertebrae));

        axialService.deleteById(EnumsBio.AxialBoneType.VERTEBRAE, 5L);

        verify(axialRepository).delete(vertebrae);
    }

    @Test
    void testDeleteVertebraeEntityNotFound() {
        when(axialRepository.getVertebraeById(5L)).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
                axialService.deleteById(EnumsBio.AxialBoneType.VERTEBRAE, 5L)
        );

        assertEquals("Vertebrae not found with id: 5", exception.getMessage());
        verify(axialRepository, never()).delete(any());
    }
}
