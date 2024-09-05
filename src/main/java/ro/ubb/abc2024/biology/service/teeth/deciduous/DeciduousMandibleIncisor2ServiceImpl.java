package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleIncisor2Mapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMandibleIncisor2Repository;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

import java.util.List;
import java.util.UUID;

@Service
public class DeciduousMandibleIncisor2ServiceImpl
        extends GenericServiceImpl<DeciduousMandibleIncisor2, DeciduousMandibleIncisor2Dto>
        implements SpecificToothService<DeciduousMandibleIncisor2, DeciduousMandibleIncisor2Dto> {

    private final DeciduousMandibleIncisor2Mapper mapper;

    @Autowired
    public DeciduousMandibleIncisor2ServiceImpl(DeciduousMandibleIncisor2Repository repository,
                                                DeciduousMandibleIncisor2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeciduousMandibleIncisor2 save(DeciduousMandibleIncisor2Dto dto) {
        return repository.save(mapper.toEntity(dto));

    }

    @Override
    @Transactional
    public DeciduousMandibleIncisor2 update(Long id, DeciduousMandibleIncisor2Dto dto) {
        DeciduousMandibleIncisor2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    public List<DeciduousMandibleIncisor2> getAllByArtefactId(UUID artefactId) {
        return ((DeciduousMandibleIncisor2Repository) repository).getAllByArtefactId(artefactId);
    }
}
