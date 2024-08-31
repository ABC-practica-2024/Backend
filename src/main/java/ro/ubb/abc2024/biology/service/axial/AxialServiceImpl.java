package ro.ubb.abc2024.biology.service.axial;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.axial.*;
import ro.ubb.abc2024.biology.dto.axial.*;
import ro.ubb.abc2024.biology.mapper.axial.*;
import ro.ubb.abc2024.biology.repository.axial.AxialRepository;

@RequiredArgsConstructor
@Service
public class AxialServiceImpl implements AxialService {

    private final AxialRepository axialRepository;
    private final CoccyxMapper coccyxMapper;
    private final RibsMapper ribsMapper;
    private final SacrumMapper sacrumMapper;
    private final SternumMapper sternumMapper;
    private final VertebraeMapper vertebraeMapper;

    @Override
    public Axial getById(EnumsBio.AxialBoneType axialBone, Long id) {
        return switch(axialBone){
            case COCCYX -> axialRepository.getCoccyxById(id).orElseThrow(() ->
                    new EntityNotFoundException("Coccyx not found with id: " + id));
            case RIBS -> axialRepository.getRibsById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ribs not found with id: " + id));
            case SACRUM -> axialRepository.getSacrumById(id).orElseThrow(() ->
                    new EntityNotFoundException("Sacrum not found with id: " + id));
            case STERNUM -> axialRepository.getSternumById(id).orElseThrow(() ->
                    new EntityNotFoundException("Sternum not found with id: " + id));
            case VERTEBRAE -> axialRepository.getVertebraeById(id).orElseThrow(() ->
                    new EntityNotFoundException("Vertebrae not found with id: " + id));
        };
    }

    @Transactional
    @Override
    public Axial save(EnumsBio.AxialBoneType axialBone, Axial axial) {
        if (axial == null) {
            throw new IllegalArgumentException("The entity to be saved cannot be null.");
        }
        return switch (axialBone) {
            case COCCYX -> {
                if (!(axial instanceof Coccyx coccyx)) {
                    throw new IllegalArgumentException("Expected an instance of Coccyx for COCCYX.");
                }
                yield axialRepository.save(coccyx);
            }
            case RIBS -> {
                if (!(axial instanceof Ribs ribs)) {
                    throw new IllegalArgumentException("Expected an instance of Ribs for RIBS.");
                }
                yield axialRepository.save(ribs);
            }
            case SACRUM -> {
                if (!(axial instanceof Sacrum sacrum)) {
                    throw new IllegalArgumentException("Expected an instance of Sacrum for SACRUM.");
                }
                yield axialRepository.save(sacrum);
            }
            case STERNUM -> {
                if (!(axial instanceof Sternum sternum)) {
                    throw new IllegalArgumentException("Expected an instance of Sternum for STERNUM.");
                }
                yield axialRepository.save(sternum);
            }
            case VERTEBRAE -> {
                if (!(axial instanceof Vertebrae vertebrae)) {
                    throw new IllegalArgumentException("Expected an instance of Vertebrae for VERTEBRAE.");
                }
                yield axialRepository.save(vertebrae);
            }
            default -> throw new IllegalArgumentException("Unexpected axialBone value: " + axialBone);
        };
    }

    @Transactional
    @Override
    public Axial update(EnumsBio.AxialBoneType axialBone, AxialDto axial) {
        if (axial == null) {
            throw new IllegalArgumentException("AxialDto cannot be null");
        }
        return switch(axialBone){
            case COCCYX -> {
                Coccyx target = axialRepository.getCoccyxById(axial.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Coccyx not found with id: " + axial.getId()));
                if (!(axial instanceof CoccyxDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for COCCYX");
                }
                coccyxMapper.updateEntityFromDto(source, target);
                yield axialRepository.save(target);
            }
            case RIBS -> {
                Ribs target = axialRepository.getRibsById(axial.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Ribs not found with id: " + axial.getId()));
                if (!(axial instanceof RibsDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for RIBS");
                }
                ribsMapper.updateEntityFromDto(source, target);
                yield axialRepository.save(target);
            }
            case SACRUM -> {
                Sacrum target = axialRepository.getSacrumById(axial.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Sacrum not found with id: " + axial.getId()));
                if (!(axial instanceof SacrumDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for SACRUM");
                }
                sacrumMapper.updateEntityFromDto(source, target);
                yield axialRepository.save(target);
            }
            case STERNUM -> {
                Sternum target = axialRepository.getSternumById(axial.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Sternum not found with id: " + axial.getId()));
                if (!(axial instanceof SternumDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for STERNUM");
                }
                sternumMapper.updateEntityFromDto(source, target);
                yield axialRepository.save(target);
            }
            case VERTEBRAE -> {
                Vertebrae target = axialRepository.getVertebraeById(axial.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Vertebrae not found with id: " + axial.getId()));
                if (!(axial instanceof VertebraeDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for VERTEBRAE");
                }
                vertebraeMapper.updateEntityFromDto(source, target);
                yield axialRepository.save(target);
            }
        };
    }

    @Override
    public void deleteById(EnumsBio.AxialBoneType axialBone, Long id) {
        switch (axialBone){
            case COCCYX -> axialRepository.delete(axialRepository.getCoccyxById(id).orElseThrow(() ->
                    new EntityNotFoundException("Coccyx not found with id: " + id)));
            case RIBS -> axialRepository.delete(axialRepository.getRibsById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ribs not found with id: " + id)));
            case SACRUM -> axialRepository.delete(axialRepository.getSacrumById(id).orElseThrow(() ->
                    new EntityNotFoundException("Sacrum not found with id: " + id)));
            case STERNUM -> axialRepository.delete(axialRepository.getSternumById(id).orElseThrow(() ->
                    new EntityNotFoundException("Sternum not found with id: " + id)));
            case VERTEBRAE -> axialRepository.delete(axialRepository.getVertebraeById(id).orElseThrow(() ->
                    new EntityNotFoundException("Vertebrae not found with id: " + id)));
        }
    }
}
