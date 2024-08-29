package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar1Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaPremolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMaxillaPremolar1ServiceImpl extends ToothServiceImpl<PermanentMaxillaPremolar1,
        PermanentMaxillaPremolar1Dto> {

    private final PermanentMaxillaPremolar1Repository specificRepository;

    @Autowired
    public PermanentMaxillaPremolar1ServiceImpl(@Qualifier("permanentMaxillaPremolar1Repository")
                                                     JpaRepository<PermanentMaxillaPremolar1, Long> repository,
                                                PermanentMaxillaPremolar1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMaxillaPremolar1 update(Long id, PermanentMaxillaPremolar1Dto dto){
        PermanentMaxillaPremolar1 updatedEntity = super.update(id, dto);

        // PermanentPremolar fields
        updatedEntity.setOdontome(dto.getOdontome() == null ? updatedEntity.getOdontome() : dto.getOdontome());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMaxillaPremolar1 fields
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setTuberculumDentale(dto.getTuberculumDentale() == null ? updatedEntity.getTuberculumDentale() : dto.getTuberculumDentale());
        updatedEntity.setAccessCusps(dto.getAccessCusps() == null ? updatedEntity.getAccessCusps() : dto.getAccessCusps());
        updatedEntity.setAccessRidges(dto.getAccessRidges() == null ? updatedEntity.getAccessRidges() : dto.getAccessRidges());
        updatedEntity.setTriCuspedPMs(dto.getTriCuspedPMs() == null ? updatedEntity.getTriCuspedPMs() : dto.getTriCuspedPMs());

        return specificRepository.save(updatedEntity);
    }
}
