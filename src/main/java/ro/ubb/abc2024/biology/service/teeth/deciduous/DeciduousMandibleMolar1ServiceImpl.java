package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar1Dto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMandibleMolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMandibleMolar1ServiceImpl extends ToothServiceImpl<DeciduousMandibleMolar1, DeciduousMandibleMolar1Dto> {

    private final DeciduousMandibleMolar1Repository specificRepository;

    @Autowired
    public DeciduousMandibleMolar1ServiceImpl(JpaRepository<DeciduousMandibleMolar1, Long> repository,
                                              DeciduousMandibleMolar1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMandibleMolar1 update(Long id, DeciduousMandibleMolar1Dto dto){
        DeciduousMandibleMolar1 updatedEntity = super.update(id, dto);

        // DeciduousMandibleMolar1 fields
        updatedEntity.setDelta(dto.getDelta() == null ? updatedEntity.getDelta() : dto.getDelta());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());

        return specificRepository.save(updatedEntity);
    }
}
