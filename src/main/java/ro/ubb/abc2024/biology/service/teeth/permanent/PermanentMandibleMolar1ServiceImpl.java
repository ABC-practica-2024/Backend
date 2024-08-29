package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMandibleMolar1ServiceImpl
        extends GenericServiceImpl<PermanentMandibleMolar1, PermanentMandibleMolar1Dto>
        implements SpecificToothService<PermanentMandibleMolar1, PermanentMandibleMolar1Dto> {

    private final PermanentMandibleMolar1Mapper mapper;

    @Autowired
    public PermanentMandibleMolar1ServiceImpl(JpaRepository<PermanentMandibleMolar1, Long> repository,
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
}
