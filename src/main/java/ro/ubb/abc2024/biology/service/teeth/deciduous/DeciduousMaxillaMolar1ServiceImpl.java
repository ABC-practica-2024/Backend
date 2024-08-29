package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar1Dto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaMolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMaxillaMolar1ServiceImpl extends ToothServiceImpl<DeciduousMaxillaMolar1, DeciduousMaxillaMolar1Dto> {

    private final DeciduousMaxillaMolar1Repository specificRepository;

    @Autowired
    public DeciduousMaxillaMolar1ServiceImpl(@Qualifier("deciduousMaxillaMolar1Repository")
                                                 JpaRepository<DeciduousMaxillaMolar1, Long> repository,
                                             DeciduousMaxillaMolar1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMaxillaMolar1 update(Long id, DeciduousMaxillaMolar1Dto dto){
        DeciduousMaxillaMolar1 updatedEntity = super.update(id, dto);

        // DeciduousMaxillaMolar1 fields
        updatedEntity.setC2Parastyle(dto.getC2Parastyle() == null ? updatedEntity.getC2Parastyle() : dto.getC2Parastyle());
        updatedEntity.setRootSheathGroove(dto.getRootSheathGroove() == null ? updatedEntity.getRootSheathGroove() : dto.getRootSheathGroove());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());

        return specificRepository.save(updatedEntity);
    }
}
