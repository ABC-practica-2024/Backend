package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaMolar2Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaMolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMaxillaMolar2ServiceImpl
        extends GenericServiceImpl<PermanentMaxillaMolar2, PermanentMaxillaMolar2Dto>
        implements SpecificToothService<PermanentMaxillaMolar2, PermanentMaxillaMolar2Dto> {

    private final PermanentMaxillaMolar2Mapper mapper;

    @Autowired
    public PermanentMaxillaMolar2ServiceImpl(PermanentMaxillaMolar2Repository repository,
                                             PermanentMaxillaMolar2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMaxillaMolar2 save(PermanentMaxillaMolar2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMaxillaMolar2 update(Long id, PermanentMaxillaMolar2Dto dto) {
        PermanentMaxillaMolar2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMaxillaMolar2> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMaxillaMolar2Repository) repository).getAllByArtefactId(artefactId);
    }
}
