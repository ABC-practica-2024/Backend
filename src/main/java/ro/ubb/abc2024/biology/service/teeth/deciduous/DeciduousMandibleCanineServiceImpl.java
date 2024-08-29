package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleCanineMapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class DeciduousMandibleCanineServiceImpl
        extends GenericServiceImpl<DeciduousMandibleCanine, DeciduousMandibleCanineDto>
        implements SpecificToothService<DeciduousMandibleCanine, DeciduousMandibleCanineDto> {

    private final DeciduousMandibleCanineMapper mapper;

    @Autowired
    public DeciduousMandibleCanineServiceImpl(JpaRepository<DeciduousMandibleCanine, Long> repository,
                                              DeciduousMandibleCanineMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMandibleCanine save(DeciduousMandibleCanineDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public DeciduousMandibleCanine update(Long id, DeciduousMandibleCanineDto dto) {
        DeciduousMandibleCanine existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
