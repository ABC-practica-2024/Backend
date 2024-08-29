package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar2Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandiblePremolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMandiblePremolar2ServiceImpl extends ToothServiceImpl<PermanentMandiblePremolar2, PermanentMandiblePremolar2Dto> {

    private final PermanentMandiblePremolar2Repository specificRepository;

    @Autowired
    public PermanentMandiblePremolar2ServiceImpl(@Qualifier("permanentMandiblePremolar2Repository")
                                                     JpaRepository<PermanentMandiblePremolar2, Long> repository,
                                                 PermanentMandiblePremolar2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }


    @Override
    public PermanentMandiblePremolar2 update(Long id, PermanentMandiblePremolar2Dto dto) {
        PermanentMandiblePremolar2 updatedEntity = super.update(id, dto);

        // PermanentPremolar fields
        updatedEntity.setOdontome(dto.getOdontome() == null ? updatedEntity.getOdontome() : dto.getOdontome());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMandiblePremolar2 fields
        updatedEntity.setLingualCusps(dto.getLingualCusps() == null ? updatedEntity.getLingualCusps() : dto.getLingualCusps());
        updatedEntity.setCongAbscence(dto.getCongAbscence() == null ? updatedEntity.getCongAbscence() : dto.getCongAbscence());

        return specificRepository.save(updatedEntity);
    }
}
