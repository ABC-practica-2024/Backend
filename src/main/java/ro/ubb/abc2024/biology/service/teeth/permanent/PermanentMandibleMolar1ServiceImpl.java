package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar1Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleMolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMandibleMolar1ServiceImpl
        extends GenericServiceImpl<PermanentMandibleMolar1, PermanentMandibleMolar1Dto>
        implements SpecificToothService<PermanentMandibleMolar1, PermanentMandibleMolar1Dto> {

    private final PermanentMandibleMolar1Mapper mapper;

    @Autowired
    public PermanentMandibleMolar1ServiceImpl(PermanentMandibleMolar1Repository repository,
                                              PermanentMandibleMolar1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMandibleMolar1 save(PermanentMandibleMolar1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMandibleMolar1 update(Long id, PermanentMandibleMolar1Dto dto) {
        PermanentMandibleMolar1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMandibleMolar1> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMandibleMolar1Repository) repository).getAllByArtefactId(artefactId);
    }
}
