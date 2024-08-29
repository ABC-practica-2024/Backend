package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleMolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class DeciduousMandibleMolar1ServiceImpl
        extends GenericServiceImpl<DeciduousMandibleMolar1, DeciduousMandibleMolar1Dto>
        implements SpecificToothService<DeciduousMandibleMolar1, DeciduousMandibleMolar1Dto> {

    private final DeciduousMandibleMolar1Mapper mapper;

    @Autowired
    public DeciduousMandibleMolar1ServiceImpl(JpaRepository<DeciduousMandibleMolar1, Long> repository,
                                              DeciduousMandibleMolar1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMandibleMolar1 save(DeciduousMandibleMolar1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public DeciduousMandibleMolar1 update(Long id, DeciduousMandibleMolar1Dto dto) {
        DeciduousMandibleMolar1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
