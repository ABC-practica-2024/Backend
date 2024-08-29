package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandiblePremolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMandiblePremolar1ServiceImpl
        extends GenericServiceImpl<PermanentMandiblePremolar1, PermanentMandiblePremolar1Dto>
        implements SpecificToothService<PermanentMandiblePremolar1, PermanentMandiblePremolar1Dto> {

    private final PermanentMandiblePremolar1Mapper mapper;

    @Autowired
    public PermanentMandiblePremolar1ServiceImpl(JpaRepository<PermanentMandiblePremolar1, Long> repository,
                                                 PermanentMandiblePremolar1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMandiblePremolar1 save(PermanentMandiblePremolar1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMandiblePremolar1 update(Long id, PermanentMandiblePremolar1Dto dto) {
        PermanentMandiblePremolar1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
