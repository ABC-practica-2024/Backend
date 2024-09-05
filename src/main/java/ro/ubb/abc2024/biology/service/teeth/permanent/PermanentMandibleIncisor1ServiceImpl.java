package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleIncisor1Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleIncisor1Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMandibleIncisor1ServiceImpl
        extends GenericServiceImpl<PermanentMandibleIncisor1, PermanentMandibleIncisor1Dto>
        implements SpecificToothService<PermanentMandibleIncisor1, PermanentMandibleIncisor1Dto> {

    private final PermanentMandibleIncisor1Mapper mapper;

    @Autowired
    public PermanentMandibleIncisor1ServiceImpl(PermanentMandibleIncisor1Repository repository,
                                                PermanentMandibleIncisor1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMandibleIncisor1 save(PermanentMandibleIncisor1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMandibleIncisor1 update(Long id, PermanentMandibleIncisor1Dto dto) {
        PermanentMandibleIncisor1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMandibleIncisor1> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMandibleIncisor1Repository) repository).getAllByArtefactId(artefactId);
    }
}
