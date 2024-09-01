package ro.ubb.abc2024.biology.service.appendicular;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.appendicular.*;
import ro.ubb.abc2024.biology.dto.appendicular.*;
import ro.ubb.abc2024.biology.mapper.append.*;
import ro.ubb.abc2024.biology.repository.appendicular.AppendRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppendServiceImpl implements AppendService {

    private final AppendRepository appendRepository;
    private final ClavicleMapper clavicleMapper;
    private final FemurMapper femurMapper;
    private final FibulaMapper fibulaMapper;
    private final HumerusMapper humerusMapper;
    private final IliumMapper iliumMapper;
    private final InnominateOsCoxaHipBoneMapper innominateOsCoxaHipBoneMapper;
    private final IschiumMapper ischiumMapper;
    private final PatellaMapper patellaMapper;
    private final PubisMapper pubisMapper;
    private final RadiusMapper radiusMapper;
    private final ScapulaMapper scapulaMapper;
    private final TibiaMapper tibiaMapper;
    private final UlnaMapper ulnaMapper;

    @Override
    public Append getById(EnumsBio.AppendicularBoneType appendicularBone, Long id) {
        return switch (appendicularBone) {
            case CLAVICLE -> appendRepository.getClavicleById(id).orElseThrow(() ->
                    new EntityNotFoundException("Clavicle not found with id: " + id));
            case FEMUR -> appendRepository.getFemurById(id).orElseThrow(() ->
                    new EntityNotFoundException("Femur not found with id: " + id));
            case FIBULA -> appendRepository.getFibulaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Fibula not found with id: " + id));
            case HUMERUS -> appendRepository.getHumerusById(id).orElseThrow(() ->
                    new EntityNotFoundException("Humerus not found with id: " + id));
            case ILIUM -> appendRepository.getIliumById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ilium not found with id: " + id));
            case OSCOXA -> appendRepository.getInnominateOsCoxaHipBoneById(id).orElseThrow(() ->
                    new EntityNotFoundException("OsCoxa not found with id: " + id));
            case ISCHIUM -> appendRepository.getIschiumById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ischium not found with id: " + id));
            case PATELLA -> appendRepository.getPatellaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Patella not found with id: " + id));
            case PUBIS -> appendRepository.getPubisById(id).orElseThrow(() ->
                    new EntityNotFoundException("Pubis not found with id: " + id));
            case RADIUS -> appendRepository.getRadiusById(id).orElseThrow(() ->
                    new EntityNotFoundException("Radius not found with id: " + id));
            case SCAPULA -> appendRepository.getScapulaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Scapula not found with id: " + id));
            case TIBIA -> appendRepository.getTibiaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Tibia not found with id: " + id));
            case ULNA -> appendRepository.getUlnaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ulna not found with id: " + id));
        };
    }

    @Transactional
    @Override
    public Append save(EnumsBio.AppendicularBoneType appendBone, Append append) {
        log.error("Service --- save method entered");
        if (append == null) {
            throw new IllegalArgumentException("The entity to be saved cannot be null.");
        }
        return switch (appendBone) {
            case CLAVICLE -> {
                if (!(append instanceof Clavicle clavicle)) {
                    throw new IllegalArgumentException("Expected an instance of Clavicle for CLAVICLE.");
                }
                yield appendRepository.save(clavicle);
            }
            case FEMUR -> {
                if (!(append instanceof Femur femur)) {
                    throw new IllegalArgumentException("Expected an instance of Femur for FEMUR.");
                }
                yield appendRepository.save(femur);
            }
            case FIBULA -> {
                if (!(append instanceof Fibula fibula)) {
                    throw new IllegalArgumentException("Expected an instance of Fibula for FIBULA.");
                }
                yield appendRepository.save(fibula);
            }
            case HUMERUS -> {
                if (!(append instanceof Humerus humerus)) {
                    throw new IllegalArgumentException("Expected an instance of Humerus for HUMERUS.");
                }
                yield appendRepository.save(humerus);
            }
            case ILIUM -> {
                if (!(append instanceof Ilium ilium)) {
                    throw new IllegalArgumentException("Expected an instance of Ilium for ILIUM.");
                }
                yield appendRepository.save(ilium);
            }
            case OSCOXA -> {
                if (!(append instanceof InnominateOsCoxaHipBone osCoxa)) {
                    throw new IllegalArgumentException("Expected an instance of InnominateOsCoxaHipBone for OSCOXA.");
                }
                yield appendRepository.save(osCoxa);
            }
            case ISCHIUM -> {
                if (!(append instanceof Ischium ischium)) {
                    throw new IllegalArgumentException("Expected an instance of Ischium for ISCHIUM.");
                }
                yield appendRepository.save(ischium);
            }
            case PATELLA -> {
                if (!(append instanceof Patella patella)) {
                    throw new IllegalArgumentException("Expected an instance of Patella for PATELLA.");
                }
                yield appendRepository.save(patella);
            }
            case PUBIS -> {
                if (!(append instanceof Pubis pubis)) {
                    throw new IllegalArgumentException("Expected an instance of Pubis for PUBIS.");
                }
                yield appendRepository.save(pubis);
            }
            case RADIUS -> {
                if (!(append instanceof Radius radius)) {
                    throw new IllegalArgumentException("Expected an instance of Radius for RADIUS.");
                }
                yield appendRepository.save(radius);
            }
            case SCAPULA -> {
                if (!(append instanceof Scapula scapula)) {
                    throw new IllegalArgumentException("Expected an instance of Scapula for SCAPULA.");
                }
                yield appendRepository.save(scapula);
            }
            case TIBIA -> {
                if (!(append instanceof Tibia tibia)) {
                    throw new IllegalArgumentException("Expected an instance of Tibia for TIBIA.");
                }
                yield appendRepository.save(tibia);
            }
            case ULNA -> {
                if (!(append instanceof Ulna ulna)) {
                    throw new IllegalArgumentException("Expected an instance of Ulna for ULNA.");
                }
                yield appendRepository.save(ulna);
            }
        };
    }

    @Transactional
    @Override
    public Append update(EnumsBio.AppendicularBoneType appendBone, AppendDto append) {
        if (append == null) {
            throw new IllegalArgumentException("The entity to be saved cannot be null.");
        }
        return switch (appendBone) {
            case CLAVICLE -> {
                ClavicleDto source = (ClavicleDto) append;
                Clavicle target = appendRepository.getClavicleById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Clavicle not found with id: " + append.getId()));
                clavicleMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case FEMUR -> {
                FemurDto source = (FemurDto) append;
                Femur target = appendRepository.getFemurById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Femur not found with id: " + append.getId()));
                femurMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case FIBULA -> {
                FibulaDto source = (FibulaDto) append;
                Fibula target = appendRepository.getFibulaById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Fibula not found with id: " + append.getId()));
                fibulaMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case HUMERUS -> {
                HumerusDto source = (HumerusDto) append;
                Humerus target = appendRepository.getHumerusById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Humerus not found with id: " + append.getId()));
                humerusMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case ILIUM -> {
                IliumDto source = (IliumDto) append;
                Ilium target = appendRepository.getIliumById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Ilium not found with id: " + append.getId()));
                iliumMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case OSCOXA -> {
                InnominateOsCoxaHipBoneDto source = (InnominateOsCoxaHipBoneDto) append;
                InnominateOsCoxaHipBone target = appendRepository.getInnominateOsCoxaHipBoneById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("OsCoxa not found with id: " + append.getId()));
                innominateOsCoxaHipBoneMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case ISCHIUM -> {
                IschiumDto source = (IschiumDto) append;
                Ischium target = appendRepository.getIschiumById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Ischium not found with id: " + append.getId()));
                ischiumMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case PATELLA -> {
                PatellaDto source = (PatellaDto) append;
                Patella target = appendRepository.getPatellaById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Patella not found with id: " + append.getId()));
                patellaMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case PUBIS -> {
                PubisDto source = (PubisDto) append;
                Pubis target = appendRepository.getPubisById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Pubis not found with id: " + append.getId()));
                pubisMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case RADIUS -> {
                RadiusDto source = (RadiusDto) append;
                Radius target = appendRepository.getRadiusById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Radius not found with id: " + append.getId()));
                radiusMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case SCAPULA -> {
                ScapulaDto source = (ScapulaDto) append;
                Scapula target = appendRepository.getScapulaById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Scapula not found with id: " + append.getId()));
                scapulaMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case TIBIA -> {
                TibiaDto source = (TibiaDto) append;
                Tibia target = appendRepository.getTibiaById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Tibia not found with id: " + append.getId()));
                tibiaMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
            case ULNA -> {
                UlnaDto source = (UlnaDto) append;
                Ulna target = appendRepository.getUlnaById(append.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Ulna not found with id: " + append.getId()));
                ulnaMapper.updateEntityFromDto(source, target);
                yield appendRepository.save(target);
            }
        };
    }

    @Override
    public void deleteById(EnumsBio.AppendicularBoneType appendBone, Long id) {
        switch (appendBone) {
            case CLAVICLE -> appendRepository.delete(appendRepository.getClavicleById(id).orElseThrow(() ->
                    new EntityNotFoundException("Clavicle not found with id: " + id)));
            case FEMUR -> appendRepository.delete(appendRepository.getFemurById(id).orElseThrow(() ->
                    new EntityNotFoundException("Femur not found with id: " + id)));
            case FIBULA -> appendRepository.delete(appendRepository.getFibulaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Fibula not found with id: " + id)));
            case HUMERUS -> appendRepository.delete(appendRepository.getHumerusById(id).orElseThrow(() ->
                    new EntityNotFoundException("Humerus not found with id: " + id)));
            case ILIUM -> appendRepository.delete(appendRepository.getIliumById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ilium not found with id: " + id)));
            case OSCOXA -> appendRepository.delete(appendRepository.getInnominateOsCoxaHipBoneById(id).orElseThrow(() ->
                    new EntityNotFoundException("InnominateOsCoxaHipBone not found with id: " + id)));
            case ISCHIUM -> appendRepository.delete(appendRepository.getIschiumById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ischium not found with id: " + id)));
            case PATELLA -> appendRepository.delete(appendRepository.getPatellaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Patella not found with id: " + id)));
            case PUBIS -> appendRepository.delete(appendRepository.getPubisById(id).orElseThrow(() ->
                    new EntityNotFoundException("Pubis not found with id: " + id)));
            case RADIUS -> appendRepository.delete(appendRepository.getRadiusById(id).orElseThrow(() ->
                    new EntityNotFoundException("Radius not found with id: " + id)));
            case SCAPULA -> appendRepository.delete(appendRepository.getScapulaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Scapula not found with id: " + id)));
            case TIBIA -> appendRepository.delete(appendRepository.getTibiaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Tibia not found with id: " + id)));
            case ULNA -> appendRepository.delete(appendRepository.getUlnaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ulna not found with id: " + id)));
        }
    }
}
