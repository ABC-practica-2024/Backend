package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar3Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaMolar3Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaMolar3Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMaxillaMolar3ServiceImpl
        extends GenericServiceImpl<PermanentMaxillaMolar3, PermanentMaxillaMolar3Dto>
        implements SpecificToothService<PermanentMaxillaMolar3, PermanentMaxillaMolar3Dto> {

    private final PermanentMaxillaMolar3Mapper mapper;

    @Autowired
    public PermanentMaxillaMolar3ServiceImpl(PermanentMaxillaMolar3Repository repository,
                                             PermanentMaxillaMolar3Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMaxillaMolar3 save(PermanentMaxillaMolar3Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMaxillaMolar3 update(Long id, PermanentMaxillaMolar3Dto dto) {
        PermanentMaxillaMolar3 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMaxillaMolar3> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMaxillaMolar3Repository) repository).getAllByArtefactId(artefactId);
    }
}
