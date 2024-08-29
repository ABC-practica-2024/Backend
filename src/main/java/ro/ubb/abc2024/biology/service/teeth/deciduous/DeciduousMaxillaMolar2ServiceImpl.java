package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar2Dto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaMolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMaxillaMolar2ServiceImpl extends ToothServiceImpl<DeciduousMaxillaMolar2, DeciduousMaxillaMolar2Dto> {

    private final DeciduousMaxillaMolar2Repository specificRepository;

    @Autowired
    public DeciduousMaxillaMolar2ServiceImpl(JpaRepository<DeciduousMaxillaMolar2, Long> repository,
                                             DeciduousMaxillaMolar2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMaxillaMolar2 update(Long id, DeciduousMaxillaMolar2Dto dto){
        DeciduousMaxillaMolar2 updatedEntity = super.update(id, dto);

        // DeciduousMaxillaMolar2 fields
        updatedEntity.setMetacone(dto.getMetacone() == null ? updatedEntity.getMetacone() : dto.getMetacone());
        updatedEntity.setHypocone(dto.getHypocone() == null ? updatedEntity.getHypocone() : dto.getHypocone());
        updatedEntity.setCusp5(dto.getCusp5() == null ? updatedEntity.getCusp5() : dto.getCusp5());
        updatedEntity.setCarabelli(dto.getCarabelli() == null ? updatedEntity.getCarabelli() : dto.getCarabelli());
        updatedEntity.setC2Parastyle(dto.getC2Parastyle() == null ? updatedEntity.getC2Parastyle() : dto.getC2Parastyle());
        updatedEntity.setRootSheathGroove(dto.getRootSheathGroove() == null ? updatedEntity.getRootSheathGroove() : dto.getRootSheathGroove());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());

        return specificRepository.save(updatedEntity);
    }
}
