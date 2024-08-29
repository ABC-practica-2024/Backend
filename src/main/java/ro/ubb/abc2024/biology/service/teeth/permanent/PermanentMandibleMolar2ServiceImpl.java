package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar2Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMandibleMolar2ServiceImpl
        extends GenericServiceImpl<PermanentMandibleMolar2, PermanentMandibleMolar2Dto>
        implements SpecificToothService<PermanentMandibleMolar2, PermanentMandibleMolar2Dto> {

    private final PermanentMandibleMolar2Mapper mapper;

    @Autowired
    public PermanentMandibleMolar2ServiceImpl(JpaRepository<PermanentMandibleMolar2, Long> repository,
                                              PermanentMandibleMolar2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMandibleMolar2 save(PermanentMandibleMolar2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMandibleMolar2 update(Long id, PermanentMandibleMolar2Dto dto) {
        PermanentMandibleMolar2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
