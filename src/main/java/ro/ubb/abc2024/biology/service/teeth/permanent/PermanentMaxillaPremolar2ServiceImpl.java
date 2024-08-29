package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar2Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaPremolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMaxillaPremolar2ServiceImpl extends ToothServiceImpl<PermanentMaxillaPremolar2, PermanentMaxillaPremolar2Dto> {

    private final PermanentMaxillaPremolar2Repository specificRepository;

    @Autowired
    public PermanentMaxillaPremolar2ServiceImpl(@Qualifier("permanentMaxillaPremolar2Repository")
                                                     JpaRepository<PermanentMaxillaPremolar2, Long> repository,
                                                PermanentMaxillaPremolar2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }


    @Override
    public PermanentMaxillaPremolar2 update(Long id, PermanentMaxillaPremolar2Dto dto) {
        PermanentMaxillaPremolar2 updatedEntity = super.update(id, dto);

        // PermanentPremolar fields
        updatedEntity.setOdontome(dto.getOdontome() == null ? updatedEntity.getOdontome() : dto.getOdontome());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMaxillaPremolar2 fields
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setTuberculumDentale(dto.getTuberculumDentale() == null ? updatedEntity.getTuberculumDentale() : dto.getTuberculumDentale());
        updatedEntity.setAccessCusps(dto.getAccessCusps() == null ? updatedEntity.getAccessCusps() : dto.getAccessCusps());
        updatedEntity.setTricuspidRidges(dto.getTricuspidRidges() == null ? updatedEntity.getTricuspidRidges() : dto.getTricuspidRidges());
        updatedEntity.setCongAbsence(dto.getCongAbsence() == null ? updatedEntity.getCongAbsence() : dto.getCongAbsence());

        return specificRepository.save(updatedEntity);
    }
}
