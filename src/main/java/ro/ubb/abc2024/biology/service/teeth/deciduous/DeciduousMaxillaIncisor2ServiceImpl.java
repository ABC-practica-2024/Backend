package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor2;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaIncisor2Mapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaIncisor2Repository;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaMolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class DeciduousMaxillaIncisor2ServiceImpl
        extends GenericServiceImpl<DeciduousMaxillaIncisor2, DeciduousMaxillaIncisor2Dto>
        implements SpecificToothService<DeciduousMaxillaIncisor2, DeciduousMaxillaIncisor2Dto> {

    private final DeciduousMaxillaIncisor2Mapper mapper;

    @Autowired
    public DeciduousMaxillaIncisor2ServiceImpl(DeciduousMaxillaIncisor2Repository repository,
                                               DeciduousMaxillaIncisor2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMaxillaIncisor2 save(DeciduousMaxillaIncisor2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public DeciduousMaxillaIncisor2 update(Long id, DeciduousMaxillaIncisor2Dto dto) {
        DeciduousMaxillaIncisor2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<DeciduousMaxillaIncisor2> getAllByArtefactId(UUID artefactId) {
        return ((DeciduousMaxillaIncisor2Repository) repository).getAllByArtefactId(artefactId);
    }
}
