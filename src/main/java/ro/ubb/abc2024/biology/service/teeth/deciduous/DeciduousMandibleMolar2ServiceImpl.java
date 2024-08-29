package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar2Dto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMandibleMolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMandibleMolar2ServiceImpl extends ToothServiceImpl<DeciduousMandibleMolar2, DeciduousMandibleMolar2Dto> {

    private final DeciduousMandibleMolar2Repository specificRepository;

    @Autowired
    public DeciduousMandibleMolar2ServiceImpl(JpaRepository<DeciduousMandibleMolar2, Long> repository,
                                              DeciduousMandibleMolar2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMandibleMolar2 update(Long id, DeciduousMandibleMolar2Dto dto){
        DeciduousMandibleMolar2 updatedEntity = super.update(id, dto);

        // DeciduousMandibleMolar2 fields
        updatedEntity.setGroovePattern(dto.getGroovePattern() == null ? updatedEntity.getGroovePattern() : dto.getGroovePattern());
        updatedEntity.setCuspNumber(dto.getCuspNumber() == null ? updatedEntity.getCuspNumber() : dto.getCuspNumber());
        updatedEntity.setDeflectingWrinkle(dto.getDeflectingWrinkle() == null ? updatedEntity.getDeflectingWrinkle() : dto.getDeflectingWrinkle());
        updatedEntity.setDistalTrigonCrest(dto.getDistalTrigonCrest() == null ? updatedEntity.getDistalTrigonCrest() : dto.getDistalTrigonCrest());
        updatedEntity.setProtostylid(dto.getProtostylid() == null ? updatedEntity.getProtostylid() : dto.getProtostylid());
        updatedEntity.setCusp5(dto.getCusp5() == null ? updatedEntity.getCusp5() : dto.getCusp5());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());

        return specificRepository.save(updatedEntity);
    }
}
