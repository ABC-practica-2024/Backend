package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaMolar2Mapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaMolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class DeciduousMaxillaMolar2ServiceImpl
        extends GenericServiceImpl<DeciduousMaxillaMolar2, DeciduousMaxillaMolar2Dto>
        implements SpecificToothService<DeciduousMaxillaMolar2, DeciduousMaxillaMolar2Dto> {

    private final DeciduousMaxillaMolar2Mapper mapper;

    @Autowired
    public DeciduousMaxillaMolar2ServiceImpl(DeciduousMaxillaMolar2Repository repository,
                                             DeciduousMaxillaMolar2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMaxillaMolar2 save(DeciduousMaxillaMolar2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public DeciduousMaxillaMolar2 update(Long id, DeciduousMaxillaMolar2Dto dto) {
        DeciduousMaxillaMolar2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<DeciduousMaxillaMolar2> getAllByArtefactId(UUID artefactId) {
        return ((DeciduousMaxillaMolar2Repository) repository).getAllByArtefactId(artefactId);
    }
}
