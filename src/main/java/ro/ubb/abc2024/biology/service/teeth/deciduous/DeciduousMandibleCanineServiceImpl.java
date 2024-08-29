package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleCanineDto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMandibleCanineRepository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMandibleCanineServiceImpl extends ToothServiceImpl<DeciduousMandibleCanine, DeciduousMandibleCanineDto> {

    private final DeciduousMandibleCanineRepository specificRepository;

    @Autowired
    public DeciduousMandibleCanineServiceImpl(JpaRepository<DeciduousMandibleCanine, Long> repository,
                                              DeciduousMandibleCanineRepository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMandibleCanine update(Long id, DeciduousMandibleCanineDto dto){
        DeciduousMandibleCanine updatedEntity = super.update(id, dto);

        // DeciduousMandibleCanine fields
        updatedEntity.setRootGroove(dto.getRootGroove() == null ? updatedEntity.getRootGroove() : dto.getRootGroove());
        updatedEntity.setDAR(dto.getDAR() == null ? updatedEntity.getDAR() : dto.getDAR());

        return specificRepository.save(updatedEntity);
    }
}
