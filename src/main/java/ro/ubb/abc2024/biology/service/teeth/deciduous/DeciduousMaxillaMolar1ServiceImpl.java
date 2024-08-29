package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaMolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class DeciduousMaxillaMolar1ServiceImpl
        extends GenericServiceImpl<DeciduousMaxillaMolar1, DeciduousMaxillaMolar1Dto>
        implements SpecificToothService<DeciduousMaxillaMolar1, DeciduousMaxillaMolar1Dto> {

    private final DeciduousMaxillaMolar1Mapper mapper;

    @Autowired
    public DeciduousMaxillaMolar1ServiceImpl(JpaRepository<DeciduousMaxillaMolar1, Long> repository,
                                             DeciduousMaxillaMolar1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMaxillaMolar1 save(DeciduousMaxillaMolar1Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public DeciduousMaxillaMolar1 update(Long id, DeciduousMaxillaMolar1Dto dto) {
        DeciduousMaxillaMolar1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
