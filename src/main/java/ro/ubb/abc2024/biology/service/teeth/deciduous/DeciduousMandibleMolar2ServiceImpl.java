package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleMolar2Mapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMandibleMolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class DeciduousMandibleMolar2ServiceImpl
        extends GenericServiceImpl<DeciduousMandibleMolar2, DeciduousMandibleMolar2Dto>
        implements SpecificToothService<DeciduousMandibleMolar2, DeciduousMandibleMolar2Dto> {

    private final DeciduousMandibleMolar2Mapper mapper;

    @Autowired
    public DeciduousMandibleMolar2ServiceImpl(DeciduousMandibleMolar2Repository repository,
                                              DeciduousMandibleMolar2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMandibleMolar2 save(DeciduousMandibleMolar2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public DeciduousMandibleMolar2 update(Long id, DeciduousMandibleMolar2Dto dto) {
        DeciduousMandibleMolar2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<DeciduousMandibleMolar2> getAllByArtefactId(UUID artefactId) {
        return ((DeciduousMandibleMolar2Repository) repository).getAllByArtefactId(artefactId);
    }
}
