package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar1Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaMolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMaxillaMolar1ServiceImpl extends ToothServiceImpl<PermanentMaxillaMolar1, PermanentMaxillaMolar1Dto> {

    private final PermanentMaxillaMolar1Repository specificRepository;

    @Autowired
    public PermanentMaxillaMolar1ServiceImpl(@Qualifier("permanentMaxillaMolar1Repository")
                                             JpaRepository<PermanentMaxillaMolar1, Long> repository,
                                             PermanentMaxillaMolar1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMaxillaMolar1 update(Long id, PermanentMaxillaMolar1Dto dto) {
        PermanentMaxillaMolar1 updatedEntity = super.update(id, dto);

        // PermanentMolar fields
        updatedEntity.setCusp5(dto.getCusp5() == null ? updatedEntity.getCusp5() : dto.getCusp5());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMaxillaMolar1 fields
        updatedEntity.setMetacone(dto.getMetacone() == null ? updatedEntity.getMetacone() : dto.getMetacone());
        updatedEntity.setHypocone(dto.getHypocone() == null ? updatedEntity.getHypocone() : dto.getHypocone());
        updatedEntity.setCarabelli(dto.getCarabelli() == null ? updatedEntity.getCarabelli() : dto.getCarabelli());
        updatedEntity.setC2Parastyle(dto.getC2Parastyle() == null ? updatedEntity.getC2Parastyle() : dto.getC2Parastyle());

        return specificRepository.save(updatedEntity);
    }

}
