package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaPremolar2Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMaxillaPremolar2ServiceImpl
        extends GenericServiceImpl<PermanentMaxillaPremolar2, PermanentMaxillaPremolar2Dto>
        implements SpecificToothService<PermanentMaxillaPremolar2, PermanentMaxillaPremolar2Dto> {

    private final PermanentMaxillaPremolar2Mapper mapper;

    @Autowired
    public PermanentMaxillaPremolar2ServiceImpl(JpaRepository<PermanentMaxillaPremolar2, Long> repository, PermanentMaxillaPremolar2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMaxillaPremolar2 save(PermanentMaxillaPremolar2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMaxillaPremolar2 update(Long id, PermanentMaxillaPremolar2Dto dto) {
        PermanentMaxillaPremolar2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
