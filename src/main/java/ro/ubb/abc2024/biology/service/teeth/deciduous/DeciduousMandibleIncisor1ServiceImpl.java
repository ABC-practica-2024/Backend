package ro.ubb.abc2024.biology.service.teeth.deciduous;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleIncisor1Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class DeciduousMandibleIncisor1ServiceImpl
        extends GenericServiceImpl<DeciduousMandibleIncisor1, DeciduousMandibleIncisor1Dto>
        implements SpecificToothService<DeciduousMandibleIncisor1, DeciduousMandibleIncisor1Dto> {

    private final DeciduousMandibleIncisor1Mapper mapper;

    @Autowired
    public DeciduousMandibleIncisor1ServiceImpl(JpaRepository<DeciduousMandibleIncisor1, Long> repository,
                                                DeciduousMandibleIncisor1Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }


    @Override
    @Transactional
    public DeciduousMandibleIncisor1 save(DeciduousMandibleIncisor1Dto dto) {
        return repository.save(mapper.toEntity(dto));

    }

    @Override
    @Transactional
    public DeciduousMandibleIncisor1 update(Long id, DeciduousMandibleIncisor1Dto dto) {
        DeciduousMandibleIncisor1 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
