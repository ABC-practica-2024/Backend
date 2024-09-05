package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar3Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar3Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleMolar3Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMandibleMolar3ServiceImpl
        extends GenericServiceImpl<PermanentMandibleMolar3, PermanentMandibleMolar3Dto>
        implements SpecificToothService<PermanentMandibleMolar3, PermanentMandibleMolar3Dto> {

    private final PermanentMandibleMolar3Mapper mapper;

    @Autowired
    public PermanentMandibleMolar3ServiceImpl(PermanentMandibleMolar3Repository repository,
                                              PermanentMandibleMolar3Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMandibleMolar3 save(PermanentMandibleMolar3Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMandibleMolar3 update(Long id, PermanentMandibleMolar3Dto dto) {
        PermanentMandibleMolar3 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMandibleMolar3> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMandibleMolar3Repository) repository).getAllByArtefactId(artefactId);
    }
}
