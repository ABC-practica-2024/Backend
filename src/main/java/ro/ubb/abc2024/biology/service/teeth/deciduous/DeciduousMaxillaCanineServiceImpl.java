package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaCanineMapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaCanineRepository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class DeciduousMaxillaCanineServiceImpl
        extends GenericServiceImpl<DeciduousMaxillaCanine, DeciduousMaxillaCanineDto>
        implements SpecificToothService<DeciduousMaxillaCanine, DeciduousMaxillaCanineDto> {

    private final DeciduousMaxillaCanineMapper mapper;

    @Autowired
    public DeciduousMaxillaCanineServiceImpl(DeciduousMaxillaCanineRepository repository,
                                             DeciduousMaxillaCanineMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMaxillaCanine save(DeciduousMaxillaCanineDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public DeciduousMaxillaCanine update(Long id, DeciduousMaxillaCanineDto dto) {
        DeciduousMaxillaCanine existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<DeciduousMaxillaCanine> getAllByArtefactId(UUID artefactId) {
        return ((DeciduousMaxillaCanineRepository) repository).getAllByArtefactId(artefactId);
    }
}
