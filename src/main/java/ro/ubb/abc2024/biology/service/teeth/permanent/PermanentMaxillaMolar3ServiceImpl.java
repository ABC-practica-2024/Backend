package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar3Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaMolar3Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMaxillaMolar3ServiceImpl
        extends GenericServiceImpl<PermanentMaxillaMolar3, PermanentMaxillaMolar3Dto>
        implements SpecificToothService<PermanentMaxillaMolar3, PermanentMaxillaMolar3Dto> {

    private final PermanentMaxillaMolar3Mapper mapper;

    @Autowired
    public PermanentMaxillaMolar3ServiceImpl(JpaRepository<PermanentMaxillaMolar3, Long> repository,
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
}
