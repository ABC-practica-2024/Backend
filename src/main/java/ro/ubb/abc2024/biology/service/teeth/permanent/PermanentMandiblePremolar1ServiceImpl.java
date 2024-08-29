package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar1Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandiblePremolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMandiblePremolar1ServiceImpl extends ToothServiceImpl<PermanentMandiblePremolar1,
        PermanentMandiblePremolar1Dto> {

    private final PermanentMandiblePremolar1Repository specificRepository;

    @Autowired
    public PermanentMandiblePremolar1ServiceImpl(@Qualifier("permanentMandiblePremolar1Repository")
                                                     JpaRepository<PermanentMandiblePremolar1, Long> repository,
                                                 PermanentMandiblePremolar1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMandiblePremolar1 update(Long id, PermanentMandiblePremolar1Dto dto){
        PermanentMandiblePremolar1 updatedEntity = super.update(id, dto);

        // PermanentPremolar fields
        updatedEntity.setOdontome(dto.getOdontome() == null ? updatedEntity.getOdontome() : dto.getOdontome());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMandiblePremolar1 fields
        updatedEntity.setLingualCusps(dto.getLingualCusps() == null ? updatedEntity.getLingualCusps() : dto.getLingualCusps());
        updatedEntity.setCusp7(dto.getCusp7() == null ? updatedEntity.getCusp7() : dto.getCusp7());

        return specificRepository.save(updatedEntity);
    }
}
