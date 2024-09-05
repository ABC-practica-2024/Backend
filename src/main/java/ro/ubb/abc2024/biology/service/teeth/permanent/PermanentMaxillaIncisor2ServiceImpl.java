package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaIncisor2Mapper;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaIncisor2Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class PermanentMaxillaIncisor2ServiceImpl
        extends GenericServiceImpl<PermanentMaxillaIncisor2, PermanentMaxillaIncisor2Dto>
        implements SpecificToothService<PermanentMaxillaIncisor2, PermanentMaxillaIncisor2Dto> {

    private final PermanentMaxillaIncisor2Mapper mapper;

    @Autowired
    public PermanentMaxillaIncisor2ServiceImpl(PermanentMaxillaIncisor2Repository repository,
                                               PermanentMaxillaIncisor2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMaxillaIncisor2 save(PermanentMaxillaIncisor2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMaxillaIncisor2 update(Long id, PermanentMaxillaIncisor2Dto dto) {
        PermanentMaxillaIncisor2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<PermanentMaxillaIncisor2> getAllByArtefactId(UUID artefactId) {
        return ((PermanentMaxillaIncisor2Repository) repository).getAllByArtefactId(artefactId);
    }
}
