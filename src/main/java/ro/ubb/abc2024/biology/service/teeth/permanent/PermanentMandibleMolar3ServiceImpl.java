package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar3Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar3Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMandibleMolar3ServiceImpl
        extends GenericServiceImpl<PermanentMandibleMolar3, PermanentMandibleMolar3Dto>
        implements SpecificToothService<PermanentMandibleMolar3, PermanentMandibleMolar3Dto> {

    private final PermanentMandibleMolar3Mapper mapper;

    @Autowired
    public PermanentMandibleMolar3ServiceImpl(JpaRepository<PermanentMandibleMolar3, Long> repository,
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
}
