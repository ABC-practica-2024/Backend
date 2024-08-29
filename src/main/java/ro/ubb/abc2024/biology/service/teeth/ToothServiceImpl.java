package ro.ubb.abc2024.biology.service.teeth;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.Tooth;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;


@Service
public class ToothServiceImpl extends GenericServiceImpl<Tooth, ToothDto> implements SpecificToothService<Tooth, ToothDto> {

    private final JpaRepository<Tooth, Long> repository;
    private final ToothMapper mapper;

    @Autowired
    public ToothServiceImpl(JpaRepository<Tooth, Long> repository, JpaRepository<Tooth, Long> repository1, ToothMapper mapper) {
        super(repository);
        this.repository = repository1;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Tooth save(ToothDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public Tooth update(Long id, ToothDto dto) {
        Tooth existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }
}