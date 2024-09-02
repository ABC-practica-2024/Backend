package ro.ubb.abc2024.biology.service.appendicular;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.appendicular.*;
import ro.ubb.abc2024.biology.dto.appendicular.*;
import ro.ubb.abc2024.biology.mapper.append.*;
import ro.ubb.abc2024.biology.repository.appendicular.AppendRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppendServiceImplTest {

    @Mock
    private AppendRepository appendRepository;
    @Mock
    private ClavicleMapper clavicleMapper;
    @Mock
    private FemurMapper femurMapper;
    @Mock
    private FibulaMapper fibulaMapper;
    @Mock
    private HumerusMapper humerusMapper;
    @Mock
    private IliumMapper iliumMapper;
    @Mock
    private InnominateOsCoxaHipBoneMapper innominateOsCoxaHipBoneMapper;
    @Mock
    private IschiumMapper ischiumMapper;
    @Mock
    private PatellaMapper patellaMapper;
    @Mock
    private PubisMapper pubisMapper;
    @Mock
    private RadiusMapper radiusMapper;
    @Mock
    private ScapulaMapper scapulaMapper;
    @Mock
    private TibiaMapper tibiaMapper;
    @Mock
    private UlnaMapper ulnaMapper;


    @InjectMocks
    private AppendServiceImpl appendService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // --------- Tests for getById method ---------

    @Test
    void testGetByIdClavicle() {
        Clavicle clavicle = new Clavicle();
        when(appendRepository.getClavicleById(1L)).thenReturn(Optional.of(clavicle));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.CLAVICLE, 1L);

        assertEquals(clavicle, result);
        verify(appendRepository).getClavicleById(1L);
    }

    @Test
    void testGetByIdClavicleNotFound() {
        when(appendRepository.getClavicleById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.CLAVICLE, 1L)
        );
    }

    @Test
    void testGetByIdFemur() {
        Femur femur = new Femur();
        when(appendRepository.getFemurById(1L)).thenReturn(Optional.of(femur));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.FEMUR, 1L);

        assertEquals(femur, result);
        verify(appendRepository).getFemurById(1L);
    }

    @Test
    void testGetByIdFemurNotFound() {
        when(appendRepository.getFemurById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.FEMUR, 1L)
        );
    }

    @Test
    void testGetByIdFibula() {
        Fibula fibula = new Fibula();
        when(appendRepository.getFibulaById(1L)).thenReturn(Optional.of(fibula));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.FIBULA, 1L);

        assertEquals(fibula, result);
        verify(appendRepository).getFibulaById(1L);
    }

    @Test
    void testGetByIdFibulaNotFound() {
        when(appendRepository.getFibulaById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.FIBULA, 1L)
        );
    }

    @Test
    void testGetByIdHumerus() {
        Humerus humerus = new Humerus();
        when(appendRepository.getHumerusById(1L)).thenReturn(Optional.of(humerus));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.HUMERUS, 1L);

        assertEquals(humerus, result);
        verify(appendRepository).getHumerusById(1L);
    }

    @Test
    void testGetByIdHumerusNotFound() {
        when(appendRepository.getHumerusById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.HUMERUS, 1L)
        );
    }

    @Test
    void testGetByIdIlium() {
        Ilium ilium = new Ilium();
        when(appendRepository.getIliumById(1L)).thenReturn(Optional.of(ilium));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.ILIUM, 1L);

        assertEquals(ilium, result);
        verify(appendRepository).getIliumById(1L);
    }

    @Test
    void testGetByIdIliumNotFound() {
        when(appendRepository.getIliumById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.ILIUM, 1L)
        );
    }

    @Test
    void testGetByIdOsCoxa() {
        InnominateOsCoxaHipBone osCoxa = new InnominateOsCoxaHipBone();
        when(appendRepository.getInnominateOsCoxaHipBoneById(1L)).thenReturn(Optional.of(osCoxa));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.OSCOXA, 1L);

        assertEquals(osCoxa, result);
        verify(appendRepository).getInnominateOsCoxaHipBoneById(1L);
    }

    @Test
    void testGetByIdOsCoxaNotFound() {
        when(appendRepository.getInnominateOsCoxaHipBoneById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.OSCOXA, 1L)
        );
    }


    @Test
    void testGetByIdUlna() {
        Ulna ulna = new Ulna();
        when(appendRepository.getUlnaById(1L)).thenReturn(Optional.of(ulna));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.ULNA, 1L);

        assertEquals(ulna, result);
        verify(appendRepository).getUlnaById(1L);
    }

    @Test
    void testGetByIdUlnaNotFound() {
        when(appendRepository.getUlnaById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.ULNA, 1L)
        );
    }

    @Test
    void testGetByIdIschium() {
        Ischium ischium = new Ischium();
        when(appendRepository.getIschiumById(1L)).thenReturn(Optional.of(ischium));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.ISCHIUM, 1L);

        assertEquals(ischium, result);
        verify(appendRepository).getIschiumById(1L);
    }

    @Test
    void testGetByIdIschiumNotFound() {
        when(appendRepository.getIschiumById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.ISCHIUM, 1L)
        );
    }


    @Test
    void testGetByIdPatella() {
        Patella patella = new Patella();
        when(appendRepository.getPatellaById(1L)).thenReturn(Optional.of(patella));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.PATELLA, 1L);

        assertEquals(patella, result);
        verify(appendRepository).getPatellaById(1L);
    }

    @Test
    void testGetByIdPatellaNotFound() {
        when(appendRepository.getPatellaById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.PATELLA, 1L)
        );
    }


    @Test
    void testGetByIdPubis() {
        Pubis pubis = new Pubis();
        when(appendRepository.getPubisById(1L)).thenReturn(Optional.of(pubis));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.PUBIS, 1L);

        assertEquals(pubis, result);
        verify(appendRepository).getPubisById(1L);
    }

    @Test
    void testGetByIdPubisNotFound() {
        when(appendRepository.getPubisById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.PUBIS, 1L)
        );
    }

    @Test
    void testGetByIdRadius() {
        Radius radius = new Radius();
        when(appendRepository.getRadiusById(1L)).thenReturn(Optional.of(radius));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.RADIUS, 1L);

        assertEquals(radius, result);
        verify(appendRepository).getRadiusById(1L);
    }

    @Test
    void testGetByIdRadiusNotFound() {
        when(appendRepository.getRadiusById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.RADIUS, 1L)
        );
    }

    @Test
    void testGetByIdScapula() {
        Scapula scapula = new Scapula();
        when(appendRepository.getScapulaById(1L)).thenReturn(Optional.of(scapula));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.SCAPULA, 1L);

        assertEquals(scapula, result);
        verify(appendRepository).getScapulaById(1L);
    }

    @Test
    void testGetByIdScapulaNotFound() {
        when(appendRepository.getScapulaById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.SCAPULA, 1L)
        );
    }


    @Test
    void testGetByIdTibia() {
        Tibia tibia = new Tibia();
        when(appendRepository.getTibiaById(1L)).thenReturn(Optional.of(tibia));

        Append result = appendService.getById(EnumsBio.AppendicularBoneType.TIBIA, 1L);

        assertEquals(tibia, result);
        verify(appendRepository).getTibiaById(1L);
    }

    @Test
    void testGetByIdTibiaNotFound() {
        when(appendRepository.getTibiaById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.getById(EnumsBio.AppendicularBoneType.TIBIA, 1L)
        );
    }


    // --------- Tests for save method ---------


    @Test
    void testSaveClavicle() {
        Clavicle clavicle = new Clavicle();
        when(appendRepository.save(clavicle)).thenReturn(clavicle);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.CLAVICLE, clavicle);

        assertEquals(clavicle, result);
        verify(appendRepository).save(clavicle);
    }

    @Test
    void testSaveClavicleWithWrongType() {
        Femur femur = new Femur();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.CLAVICLE, femur)
        );
    }

    @Test
    void testSaveFemur() {
        Femur femur = new Femur();
        when(appendRepository.save(femur)).thenReturn(femur);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.FEMUR, femur);

        assertEquals(femur, result);
        verify(appendRepository).save(femur);
    }

    @Test
    void testSaveFemurWithWrongType() {
        Clavicle clavicle = new Clavicle();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.FEMUR, clavicle)
        );
    }

    @Test
    void testSaveNullAppend() {
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.CLAVICLE, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.FEMUR, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.FIBULA, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.HUMERUS, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.ILIUM, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.OSCOXA, null)
        );

        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.ISCHIUM, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.PATELLA, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.PUBIS, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.RADIUS, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.SCAPULA, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.TIBIA, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.ULNA, null)
        );
    }

    @Test
    void testSaveFibula() {
        Fibula fibula = new Fibula();
        when(appendRepository.save(fibula)).thenReturn(fibula);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.FIBULA, fibula);

        assertEquals(fibula, result);
        verify(appendRepository).save(fibula);
    }

    @Test
    void testSaveFibulaWithWrongType() {
        Clavicle clavicle = new Clavicle();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.FIBULA, clavicle)
        );
    }

    @Test
    void testSaveHumerus() {
        Humerus humerus = new Humerus();
        when(appendRepository.save(humerus)).thenReturn(humerus);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.HUMERUS, humerus);

        assertEquals(humerus, result);
        verify(appendRepository).save(humerus);
    }

    @Test
    void testSaveHumerusWithWrongType() {
        Clavicle clavicle = new Clavicle();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.HUMERUS, clavicle)
        );
    }


    @Test
    void testSaveIlium() {
        Ilium ilium = new Ilium();
        when(appendRepository.save(ilium)).thenReturn(ilium);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.ILIUM, ilium);

        assertEquals(ilium, result);
        verify(appendRepository).save(ilium);
    }

    @Test
    void testSaveIliumWithWrongType() {
        Clavicle clavicle = new Clavicle();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.ILIUM, clavicle)
        );
    }


    @Test
    void testSaveOsCoxa() {
        InnominateOsCoxaHipBone osCoxa = new InnominateOsCoxaHipBone();
        when(appendRepository.save(osCoxa)).thenReturn(osCoxa);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.OSCOXA, osCoxa);

        assertEquals(osCoxa, result);
        verify(appendRepository).save(osCoxa);
    }

    @Test
    void testSaveOsCoxaWithWrongType() {
        Clavicle clavicle = new Clavicle();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.OSCOXA, clavicle)
        );
    }


    @Test
    void testSaveIschium() {
        Ischium ischium = new Ischium();
        when(appendRepository.save(ischium)).thenReturn(ischium);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.ISCHIUM, ischium);

        assertEquals(ischium, result);
        verify(appendRepository).save(ischium);
    }

    @Test
    void testSaveIschiumWithWrongType() {
        Patella patella = new Patella();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.ISCHIUM, patella)
        );
    }


    @Test
    void testSavePatella() {
        Patella patella = new Patella();
        when(appendRepository.save(patella)).thenReturn(patella);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.PATELLA, patella);

        assertEquals(patella, result);
        verify(appendRepository).save(patella);
    }

    @Test
    void testSavePatellaWithWrongType() {
        Ischium ischium = new Ischium();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.PATELLA, ischium)
        );
    }


    @Test
    void testSavePubis() {
        Pubis pubis = new Pubis();
        when(appendRepository.save(pubis)).thenReturn(pubis);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.PUBIS, pubis);

        assertEquals(pubis, result);
        verify(appendRepository).save(pubis);
    }

    @Test
    void testSavePubisWithWrongType() {
        Radius radius = new Radius();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.PUBIS, radius)
        );
    }


    @Test
    void testSaveRadius() {
        Radius radius = new Radius();
        when(appendRepository.save(radius)).thenReturn(radius);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.RADIUS, radius);

        assertEquals(radius, result);
        verify(appendRepository).save(radius);
    }

    @Test
    void testSaveRadiusWithWrongType() {
        Scapula scapula = new Scapula();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.RADIUS, scapula)
        );
    }


    @Test
    void testSaveScapula() {
        Scapula scapula = new Scapula();
        when(appendRepository.save(scapula)).thenReturn(scapula);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.SCAPULA, scapula);

        assertEquals(scapula, result);
        verify(appendRepository).save(scapula);
    }

    @Test
    void testSaveScapulaWithWrongType() {
        Tibia tibia = new Tibia();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.SCAPULA, tibia)
        );
    }


    @Test
    void testSaveTibia() {
        Tibia tibia = new Tibia();
        when(appendRepository.save(tibia)).thenReturn(tibia);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.TIBIA, tibia);

        assertEquals(tibia, result);
        verify(appendRepository).save(tibia);
    }

    @Test
    void testSaveTibiaWithWrongType() {
        Ulna ulna = new Ulna();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.TIBIA, ulna)
        );
    }


    @Test
    void testSaveUlna() {
        Ulna ulna = new Ulna();
        when(appendRepository.save(ulna)).thenReturn(ulna);

        Append result = appendService.save(EnumsBio.AppendicularBoneType.ULNA, ulna);

        assertEquals(ulna, result);
        verify(appendRepository).save(ulna);
    }

    @Test
    void testSaveUlnaWithWrongType() {
        Tibia tibia = new Tibia();
        assertThrows(IllegalArgumentException.class, () ->
                appendService.save(EnumsBio.AppendicularBoneType.ULNA, tibia)
        );
    }


    // --------- Tests for update method ---------


    @Test
    void testUpdateIschium() {
        IschiumDto ischiumDto = new IschiumDto();
        ischiumDto.setId(1L);
        Ischium ischium = new Ischium();

        when(appendRepository.getIschiumById(1L)).thenReturn(java.util.Optional.of(ischium));
        when(appendRepository.save(ischium)).thenReturn(ischium);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.ISCHIUM, ischiumDto);

        verify(ischiumMapper).updateEntityFromDto(ischiumDto, ischium);
        verify(appendRepository).save(ischium);
        assertEquals(ischium, result);
    }

    @Test
    void testUpdateIschiumNotFound() {
        IschiumDto ischiumDto = new IschiumDto();
        ischiumDto.setId(1L);

        when(appendRepository.getIschiumById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.ISCHIUM, ischiumDto)
        );
    }

    @Test
    void testUpdateIschiumWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.ISCHIUM, new PatellaDto())
        );
    }


    @Test
    void testUpdatePatella() {
        PatellaDto patellaDto = new PatellaDto();
        patellaDto.setId(2L);
        Patella patella = new Patella();

        when(appendRepository.getPatellaById(2L)).thenReturn(java.util.Optional.of(patella));
        when(appendRepository.save(patella)).thenReturn(patella);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.PATELLA, patellaDto);

        verify(patellaMapper).updateEntityFromDto(patellaDto, patella);
        verify(appendRepository).save(patella);
        assertEquals(patella, result);
    }

    @Test
    void testUpdatePatellaNotFound() {
        PatellaDto patellaDto = new PatellaDto();
        patellaDto.setId(2L);

        when(appendRepository.getPatellaById(2L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.PATELLA, patellaDto)
        );
    }

    @Test
    void testUpdatePatellaWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.PATELLA, new IschiumDto())
        );
    }



    @Test
    void testUpdatePubis() {
        PubisDto pubisDto = new PubisDto();
        pubisDto.setId(3L);
        Pubis pubis = new Pubis();

        when(appendRepository.getPubisById(3L)).thenReturn(java.util.Optional.of(pubis));
        when(appendRepository.save(pubis)).thenReturn(pubis);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.PUBIS, pubisDto);

        verify(pubisMapper).updateEntityFromDto(pubisDto, pubis);
        verify(appendRepository).save(pubis);
        assertEquals(pubis, result);
    }

    @Test
    void testUpdatePubisNotFound() {
        PubisDto pubisDto = new PubisDto();
        pubisDto.setId(3L);

        when(appendRepository.getPubisById(3L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.PUBIS, pubisDto)
        );
    }

    @Test
    void testUpdateRadius() {
        RadiusDto radiusDto = new RadiusDto();
        radiusDto.setId(4L);
        Radius radius = new Radius();

        when(appendRepository.getRadiusById(4L)).thenReturn(java.util.Optional.of(radius));
        when(appendRepository.save(radius)).thenReturn(radius);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.RADIUS, radiusDto);

        verify(radiusMapper).updateEntityFromDto(radiusDto, radius);
        verify(appendRepository).save(radius);
        assertEquals(radius, result);
    }

    @Test
    void testUpdateRadiusNotFound() {
        RadiusDto radiusDto = new RadiusDto();
        radiusDto.setId(4L);

        when(appendRepository.getRadiusById(4L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.RADIUS, radiusDto)
        );
    }

    @Test
    void testUpdateScapula() {
        ScapulaDto scapulaDto = new ScapulaDto();
        scapulaDto.setId(5L);
        Scapula scapula = new Scapula();

        when(appendRepository.getScapulaById(5L)).thenReturn(java.util.Optional.of(scapula));
        when(appendRepository.save(scapula)).thenReturn(scapula);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.SCAPULA, scapulaDto);

        verify(scapulaMapper).updateEntityFromDto(scapulaDto, scapula);
        verify(appendRepository).save(scapula);
        assertEquals(scapula, result);
    }

    @Test
    void testUpdateScapulaNotFound() {
        ScapulaDto scapulaDto = new ScapulaDto();
        scapulaDto.setId(5L);

        when(appendRepository.getScapulaById(5L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.SCAPULA, scapulaDto)
        );
    }

    @Test
    void testUpdateUlna() {
        UlnaDto ulnaDto = new UlnaDto();
        ulnaDto.setId(6L);
        Ulna ulna = new Ulna();

        when(appendRepository.getUlnaById(6L)).thenReturn(java.util.Optional.of(ulna));
        when(appendRepository.save(ulna)).thenReturn(ulna);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.ULNA, ulnaDto);

        verify(ulnaMapper).updateEntityFromDto(ulnaDto, ulna);
        verify(appendRepository).save(ulna);
        assertEquals(ulna, result);
    }

    @Test
    void testUpdateUlnaNotFound() {
        UlnaDto ulnaDto = new UlnaDto();
        ulnaDto.setId(6L);

        when(appendRepository.getUlnaById(6L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.ULNA, ulnaDto)
        );
    }


    @Test
    void testUpdateNullAppend() {
        assertThrows(IllegalArgumentException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.ULNA, null)
        );
    }

    @Test
    void testUpdateClavicle() {
        ClavicleDto clavicleDto = new ClavicleDto();
        clavicleDto.setId(1L);
        Clavicle clavicle = new Clavicle();

        when(appendRepository.getClavicleById(1L)).thenReturn(java.util.Optional.of(clavicle));
        when(appendRepository.save(clavicle)).thenReturn(clavicle);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.CLAVICLE, clavicleDto);

        verify(clavicleMapper).updateEntityFromDto(clavicleDto, clavicle);
        verify(appendRepository).save(clavicle);
        assertEquals(clavicle, result);
    }

    @Test
    void testUpdateClavicleNotFound() {
        ClavicleDto clavicleDto = new ClavicleDto();
        clavicleDto.setId(1L);

        when(appendRepository.getClavicleById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.CLAVICLE, clavicleDto)
        );
    }

    @Test
    void testUpdateClavicleWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.CLAVICLE, new FemurDto())
        );
    }


    @Test
    void testUpdateFemur() {
        FemurDto femurDto = new FemurDto();
        femurDto.setId(2L);
        Femur femur = new Femur();

        when(appendRepository.getFemurById(2L)).thenReturn(java.util.Optional.of(femur));
        when(appendRepository.save(femur)).thenReturn(femur);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.FEMUR, femurDto);

        verify(femurMapper).updateEntityFromDto(femurDto, femur);
        verify(appendRepository).save(femur);
        assertEquals(femur, result);
    }

    @Test
    void testUpdateFemurNotFound() {
        FemurDto femurDto = new FemurDto();
        femurDto.setId(2L);

        when(appendRepository.getFemurById(2L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.FEMUR, femurDto)
        );
    }

    @Test
    void testUpdateFemurWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.FEMUR, new ClavicleDto())
        );
    }


    @Test
    void testUpdateFibula() {
        FibulaDto fibulaDto = new FibulaDto();
        fibulaDto.setId(3L);
        Fibula fibula = new Fibula();

        when(appendRepository.getFibulaById(3L)).thenReturn(java.util.Optional.of(fibula));
        when(appendRepository.save(fibula)).thenReturn(fibula);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.FIBULA, fibulaDto);

        verify(fibulaMapper).updateEntityFromDto(fibulaDto, fibula);
        verify(appendRepository).save(fibula);
        assertEquals(fibula, result);
    }

    @Test
    void testUpdateFibulaNotFound() {
        FibulaDto fibulaDto = new FibulaDto();
        fibulaDto.setId(3L);

        when(appendRepository.getFibulaById(3L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.FIBULA, fibulaDto)
        );
    }

    @Test
    void testUpdateFibulaWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.FIBULA, new HumerusDto())
        );
    }


    @Test
    void testUpdateHumerus() {
        HumerusDto humerusDto = new HumerusDto();
        humerusDto.setId(4L);
        Humerus humerus = new Humerus();

        when(appendRepository.getHumerusById(4L)).thenReturn(java.util.Optional.of(humerus));
        when(appendRepository.save(humerus)).thenReturn(humerus);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.HUMERUS, humerusDto);

        verify(humerusMapper).updateEntityFromDto(humerusDto, humerus);
        verify(appendRepository).save(humerus);
        assertEquals(humerus, result);
    }

    @Test
    void testUpdateHumerusNotFound() {
        HumerusDto humerusDto = new HumerusDto();
        humerusDto.setId(4L);

        when(appendRepository.getHumerusById(4L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.HUMERUS, humerusDto)
        );
    }

    @Test
    void testUpdateHumerusWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.HUMERUS, new FibulaDto())
        );
    }


    @Test
    void testUpdateIlium() {
        IliumDto iliumDto = new IliumDto();
        iliumDto.setId(5L);
        Ilium ilium = new Ilium();

        when(appendRepository.getIliumById(5L)).thenReturn(java.util.Optional.of(ilium));
        when(appendRepository.save(ilium)).thenReturn(ilium);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.ILIUM, iliumDto);

        verify(iliumMapper).updateEntityFromDto(iliumDto, ilium);
        verify(appendRepository).save(ilium);
        assertEquals(ilium, result);
    }

    @Test
    void testUpdateIliumNotFound() {
        IliumDto iliumDto = new IliumDto();
        iliumDto.setId(5L);

        when(appendRepository.getIliumById(5L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.ILIUM, iliumDto)
        );
    }

    @Test
    void testUpdateIliumWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.ILIUM, new TibiaDto())
        );
    }


    @Test
    void testUpdateOsCoxa() {
        InnominateOsCoxaHipBoneDto osCoxaDto = new InnominateOsCoxaHipBoneDto();
        osCoxaDto.setId(6L);
        InnominateOsCoxaHipBone osCoxa = new InnominateOsCoxaHipBone();

        when(appendRepository.getInnominateOsCoxaHipBoneById(6L)).thenReturn(java.util.Optional.of(osCoxa));
        when(appendRepository.save(osCoxa)).thenReturn(osCoxa);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.OSCOXA, osCoxaDto);

        verify(innominateOsCoxaHipBoneMapper).updateEntityFromDto(osCoxaDto, osCoxa);
        verify(appendRepository).save(osCoxa);
        assertEquals(osCoxa, result);
    }

    @Test
    void testUpdateOsCoxaNotFound() {
        InnominateOsCoxaHipBoneDto osCoxaDto = new InnominateOsCoxaHipBoneDto();
        osCoxaDto.setId(6L);

        when(appendRepository.getInnominateOsCoxaHipBoneById(6L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.OSCOXA, osCoxaDto)
        );
    }

    @Test
    void testUpdateOsCoxaWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.OSCOXA, new TibiaDto())
        );
    }


    @Test
    void testUpdateTibia() {
        TibiaDto tibiaDto = new TibiaDto();
        tibiaDto.setId(7L);
        Tibia tibia = new Tibia();

        when(appendRepository.getTibiaById(7L)).thenReturn(java.util.Optional.of(tibia));
        when(appendRepository.save(tibia)).thenReturn(tibia);

        Append result = appendService.update(EnumsBio.AppendicularBoneType.TIBIA, tibiaDto);

        verify(tibiaMapper).updateEntityFromDto(tibiaDto, tibia);
        verify(appendRepository).save(tibia);
        assertEquals(tibia, result);
    }

    @Test
    void testUpdateTibiaNotFound() {
        TibiaDto tibiaDto = new TibiaDto();
        tibiaDto.setId(7L);

        when(appendRepository.getTibiaById(7L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.TIBIA, tibiaDto)
        );
    }

    @Test
    void testUpdateTibiaWithWrongType() {
        assertThrows(ClassCastException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.TIBIA, new ClavicleDto())
        );
    }


    @Test
    void testUpdateWithNullAppend() {
        assertThrows(IllegalArgumentException.class, () ->
                appendService.update(EnumsBio.AppendicularBoneType.TIBIA, null)
        );
    }

    // --------- Tests for delete method ---------


    @Test
    void testDeleteClavicle() {
        Clavicle clavicle = new Clavicle();
        when(appendRepository.getClavicleById(1L)).thenReturn(java.util.Optional.of(clavicle));

        appendService.deleteById(EnumsBio.AppendicularBoneType.CLAVICLE, 1L);

        verify(appendRepository).delete(clavicle);
    }

    @Test
    void testDeleteClavicleNotFound() {
        when(appendRepository.getClavicleById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.CLAVICLE, 1L)
        );
    }


    @Test
    void testDeleteFemur() {
        Femur femur = new Femur();
        when(appendRepository.getFemurById(2L)).thenReturn(java.util.Optional.of(femur));

        appendService.deleteById(EnumsBio.AppendicularBoneType.FEMUR, 2L);

        verify(appendRepository).delete(femur);
    }

    @Test
    void testDeleteFemurNotFound() {
        when(appendRepository.getFemurById(2L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.FEMUR, 2L)
        );
    }


    @Test
    void testDeleteFibula() {
        Fibula fibula = new Fibula();
        when(appendRepository.getFibulaById(3L)).thenReturn(java.util.Optional.of(fibula));

        appendService.deleteById(EnumsBio.AppendicularBoneType.FIBULA, 3L);

        verify(appendRepository).delete(fibula);
    }

    @Test
    void testDeleteFibulaNotFound() {
        when(appendRepository.getFibulaById(3L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.FIBULA, 3L)
        );
    }


    @Test
    void testDeleteHumerus() {
        Humerus humerus = new Humerus();
        when(appendRepository.getHumerusById(4L)).thenReturn(java.util.Optional.of(humerus));

        appendService.deleteById(EnumsBio.AppendicularBoneType.HUMERUS, 4L);

        verify(appendRepository).delete(humerus);
    }

    @Test
    void testDeleteHumerusNotFound() {
        when(appendRepository.getHumerusById(4L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.HUMERUS, 4L)
        );
    }


    @Test
    void testDeleteIlium() {
        Ilium ilium = new Ilium();
        when(appendRepository.getIliumById(5L)).thenReturn(java.util.Optional.of(ilium));

        appendService.deleteById(EnumsBio.AppendicularBoneType.ILIUM, 5L);

        verify(appendRepository).delete(ilium);
    }

    @Test
    void testDeleteIliumNotFound() {
        when(appendRepository.getIliumById(5L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.ILIUM, 5L)
        );
    }


    @Test
    void testDeleteOsCoxa() {
        InnominateOsCoxaHipBone osCoxa = new InnominateOsCoxaHipBone();
        when(appendRepository.getInnominateOsCoxaHipBoneById(6L)).thenReturn(java.util.Optional.of(osCoxa));

        appendService.deleteById(EnumsBio.AppendicularBoneType.OSCOXA, 6L);

        verify(appendRepository).delete(osCoxa);
    }

    @Test
    void testDeleteOsCoxaNotFound() {
        when(appendRepository.getInnominateOsCoxaHipBoneById(6L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.OSCOXA, 6L)
        );
    }


    @Test
    void testDeleteIschium() {
        Ischium ischium = new Ischium();
        when(appendRepository.getIschiumById(7L)).thenReturn(java.util.Optional.of(ischium));

        appendService.deleteById(EnumsBio.AppendicularBoneType.ISCHIUM, 7L);

        verify(appendRepository).delete(ischium);
    }

    @Test
    void testDeleteIschiumNotFound() {
        when(appendRepository.getIschiumById(7L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.ISCHIUM, 7L)
        );
    }


    @Test
    void testDeletePatella() {
        Patella patella = new Patella();
        when(appendRepository.getPatellaById(8L)).thenReturn(java.util.Optional.of(patella));

        appendService.deleteById(EnumsBio.AppendicularBoneType.PATELLA, 8L);

        verify(appendRepository).delete(patella);
    }

    @Test
    void testDeletePatellaNotFound() {
        when(appendRepository.getPatellaById(8L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.PATELLA, 8L)
        );
    }


    @Test
    void testDeletePubis() {
        Pubis pubis = new Pubis();
        when(appendRepository.getPubisById(9L)).thenReturn(java.util.Optional.of(pubis));

        appendService.deleteById(EnumsBio.AppendicularBoneType.PUBIS, 9L);

        verify(appendRepository).delete(pubis);
    }

    @Test
    void testDeletePubisNotFound() {
        when(appendRepository.getPubisById(9L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.PUBIS, 9L)
        );
    }


    @Test
    void testDeleteRadius() {
        Radius radius = new Radius();
        when(appendRepository.getRadiusById(10L)).thenReturn(java.util.Optional.of(radius));

        appendService.deleteById(EnumsBio.AppendicularBoneType.RADIUS, 10L);

        verify(appendRepository).delete(radius);
    }

    @Test
    void testDeleteRadiusNotFound() {
        when(appendRepository.getRadiusById(10L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.RADIUS, 10L)
        );
    }


    @Test
    void testDeleteScapula() {
        Scapula scapula = new Scapula();
        when(appendRepository.getScapulaById(11L)).thenReturn(java.util.Optional.of(scapula));

        appendService.deleteById(EnumsBio.AppendicularBoneType.SCAPULA, 11L);

        verify(appendRepository).delete(scapula);
    }

    @Test
    void testDeleteScapulaNotFound() {
        when(appendRepository.getScapulaById(11L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.SCAPULA, 11L)
        );
    }


    @Test
    void testDeleteTibia() {
        Tibia tibia = new Tibia();
        when(appendRepository.getTibiaById(12L)).thenReturn(java.util.Optional.of(tibia));

        appendService.deleteById(EnumsBio.AppendicularBoneType.TIBIA, 12L);

        verify(appendRepository).delete(tibia);
    }

    @Test
    void testDeleteTibiaNotFound() {
        when(appendRepository.getTibiaById(12L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.TIBIA, 12L)
        );
    }


    @Test
    void testDeleteUlna() {
        Ulna ulna = new Ulna();
        when(appendRepository.getUlnaById(13L)).thenReturn(java.util.Optional.of(ulna));

        appendService.deleteById(EnumsBio.AppendicularBoneType.ULNA, 13L);

        verify(appendRepository).delete(ulna);
    }

    @Test
    void testDeleteUlnaNotFound() {
        when(appendRepository.getUlnaById(13L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
                appendService.deleteById(EnumsBio.AppendicularBoneType.ULNA, 13L)
        );
    }
}
