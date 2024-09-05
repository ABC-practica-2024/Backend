package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleCanineMapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleCanineRepository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMandibleCanineServiceImpl
        extends GenericServiceImpl<PermanentMandibleCanine, PermanentMandibleCanineDto>
        implements SpecificToothService<PermanentMandibleCanine, PermanentMandibleCanineDto> {

    private final PermanentMandibleCanineMapper mapper;

    @Autowired
    public PermanentMandibleCanineServiceImpl(PermanentMandibleCanineRepository repository,
                                              PermanentMandibleCanineMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public PermanentMandibleCanine save(PermanentMandibleCanineDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public PermanentMandibleCanine update(Long id, PermanentMandibleCanineDto dto) {
        PermanentMandibleCanine existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMandibleCanine> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMandibleCanineRepository) repository).getAllByArtefactId(artefactId);
    }
}
