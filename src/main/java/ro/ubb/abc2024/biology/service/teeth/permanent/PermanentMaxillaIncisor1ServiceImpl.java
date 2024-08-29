package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaIncisor1Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMaxillaIncisor1ServiceImpl
        extends GenericServiceImpl<PermanentMaxillaIncisor1, PermanentMaxillaIncisor1Dto>
        implements SpecificToothService<PermanentMaxillaIncisor1, PermanentMaxillaIncisor1Dto> {

    private final PermanentMaxillaIncisor1Mapper mapper;

    @Autowired
    public PermanentMaxillaIncisor1ServiceImpl(JpaRepository<PermanentMaxillaIncisor1, Long> repository,
                                               PermanentMaxillaIncisor1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMaxillaIncisor1 save(PermanentMaxillaIncisor1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMaxillaIncisor1 update(Long id, PermanentMaxillaIncisor1Dto dto) {
        PermanentMaxillaIncisor1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
