package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaPremolar1Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaPremolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMaxillaPremolar1ServiceImpl
        extends GenericServiceImpl<PermanentMaxillaPremolar1, PermanentMaxillaPremolar1Dto>
        implements SpecificToothService<PermanentMaxillaPremolar1, PermanentMaxillaPremolar1Dto> {

    private final PermanentMaxillaPremolar1Mapper mapper;

    @Autowired
    public PermanentMaxillaPremolar1ServiceImpl(PermanentMaxillaPremolar1Repository repository,
                                                PermanentMaxillaPremolar1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMaxillaPremolar1 save(PermanentMaxillaPremolar1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMaxillaPremolar1 update(Long id, PermanentMaxillaPremolar1Dto dto) {
        PermanentMaxillaPremolar1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMaxillaPremolar1> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMaxillaPremolar1Repository) repository).getAllByArtefactId(artefactId);
    }
}
