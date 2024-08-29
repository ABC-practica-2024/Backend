package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaMolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMaxillaMolar1ServiceImpl
        extends GenericServiceImpl<PermanentMaxillaMolar1, PermanentMaxillaMolar1Dto>
        implements SpecificToothService<PermanentMaxillaMolar1, PermanentMaxillaMolar1Dto> {

    private final PermanentMaxillaMolar1Mapper mapper;

    @Autowired
    public PermanentMaxillaMolar1ServiceImpl(JpaRepository<PermanentMaxillaMolar1, Long> repository,
                                             PermanentMaxillaMolar1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMaxillaMolar1 save(PermanentMaxillaMolar1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMaxillaMolar1 update(Long id, PermanentMaxillaMolar1Dto dto) {
        PermanentMaxillaMolar1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
