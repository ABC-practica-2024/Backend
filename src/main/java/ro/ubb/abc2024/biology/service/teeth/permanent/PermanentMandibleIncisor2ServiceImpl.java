package ro.ubb.abc2024.biology.service.teeth.permanent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleIncisor2Mapper;
import ro.ubb.abc2024.biology.service.teeth.GenericServiceImpl;
import ro.ubb.abc2024.biology.service.teeth.SpecificToothService;

@Service
public class PermanentMandibleIncisor2ServiceImpl
        extends GenericServiceImpl<PermanentMandibleIncisor2, PermanentMandibleIncisor2Dto>
        implements SpecificToothService<PermanentMandibleIncisor2, PermanentMandibleIncisor2Dto> {

    private final PermanentMandibleIncisor2Mapper mapper;

    @Autowired
    public PermanentMandibleIncisor2ServiceImpl(JpaRepository<PermanentMandibleIncisor2, Long> repository,
                                                PermanentMandibleIncisor2Mapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public PermanentMandibleIncisor2 save(PermanentMandibleIncisor2Dto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    @Override
    public PermanentMandibleIncisor2 update(Long id, PermanentMandibleIncisor2Dto dto) {
        PermanentMandibleIncisor2 existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}
