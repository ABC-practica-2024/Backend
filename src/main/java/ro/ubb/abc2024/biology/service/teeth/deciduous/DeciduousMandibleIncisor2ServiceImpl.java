package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleIncisor2Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class DeciduousMandibleIncisor2ServiceImpl
        extends GenericServiceImpl<DeciduousMandibleIncisor2, DeciduousMandibleIncisor2Dto>
        implements SpecificToothService<DeciduousMandibleIncisor2, DeciduousMandibleIncisor2Dto> {

    private final DeciduousMandibleIncisor2Mapper mapper;

    @Autowired
    public DeciduousMandibleIncisor2ServiceImpl(JpaRepository<DeciduousMandibleIncisor2, Long> repository,
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
}
