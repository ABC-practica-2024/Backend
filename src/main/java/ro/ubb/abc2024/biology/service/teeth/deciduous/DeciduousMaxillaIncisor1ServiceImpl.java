package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaIncisor1Mapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaIncisor1Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class DeciduousMaxillaIncisor1ServiceImpl
        extends GenericServiceImpl<DeciduousMaxillaIncisor1, DeciduousMaxillaIncisor1Dto>
        implements SpecificToothService<DeciduousMaxillaIncisor1, DeciduousMaxillaIncisor1Dto> {

    private final DeciduousMaxillaIncisor1Mapper mapper;

    @Autowired
    public DeciduousMaxillaIncisor1ServiceImpl(DeciduousMaxillaIncisor1Repository repository,
                                               DeciduousMaxillaIncisor1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMaxillaIncisor1 save(DeciduousMaxillaIncisor1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public DeciduousMaxillaIncisor1 update(Long id, DeciduousMaxillaIncisor1Dto dto) {
        DeciduousMaxillaIncisor1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<DeciduousMaxillaIncisor1> getAllByArtefactId(UUID artefactId) {
        return ((DeciduousMaxillaIncisor1Repository) repository).getAllByArtefactId(artefactId);
    }
}
