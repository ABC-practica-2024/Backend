package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaCanineMapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaCanineRepository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMaxillaCanineServiceImpl
        extends GenericServiceImpl<PermanentMaxillaCanine, PermanentMaxillaCanineDto>
        implements SpecificToothService<PermanentMaxillaCanine, PermanentMaxillaCanineDto> {

    private final PermanentMaxillaCanineMapper mapper;

    @Autowired
    public PermanentMaxillaCanineServiceImpl(PermanentMaxillaCanineRepository repository,
                                             PermanentMaxillaCanineMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMaxillaCanine save(PermanentMaxillaCanineDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMaxillaCanine update(Long id, PermanentMaxillaCanineDto dto) {
        PermanentMaxillaCanine existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMaxillaCanine> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMaxillaCanineRepository) repository).getAllByArtefactId(artefactId);
    }
}
