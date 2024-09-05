package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandiblePremolar2Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandiblePremolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMandiblePremolar2ServiceImpl
        extends GenericServiceImpl<PermanentMandiblePremolar2, PermanentMandiblePremolar2Dto>
        implements SpecificToothService<PermanentMandiblePremolar2, PermanentMandiblePremolar2Dto> {

    private final PermanentMandiblePremolar2Mapper mapper;

    @Autowired
    public PermanentMandiblePremolar2ServiceImpl(PermanentMandiblePremolar2Repository repository,
                                                 PermanentMandiblePremolar2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMandiblePremolar2 save(PermanentMandiblePremolar2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMandiblePremolar2 update(Long id, PermanentMandiblePremolar2Dto dto) {
        PermanentMandiblePremolar2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMandiblePremolar2> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMandiblePremolar2Repository) repository).getAllByArtefactId(artefactId);
    }
}
