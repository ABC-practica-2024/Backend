package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar2Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaMolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMaxillaMolar2ServiceImpl extends ToothServiceImpl<PermanentMaxillaMolar2, PermanentMaxillaMolar2Dto> {

    private  final PermanentMaxillaMolar2Repository specificRepository;

    @Autowired
    public PermanentMaxillaMolar2ServiceImpl(@Qualifier("permanentMaxillaMolar2Repository") JpaRepository<PermanentMaxillaMolar2, Long> repository,
                                             PermanentMaxillaMolar2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMaxillaMolar2 update(Long id, PermanentMaxillaMolar2Dto dto){
        PermanentMaxillaMolar2 updatedEntity = super.update(id, dto);

        // PermanentMolar fields
        updatedEntity.setCusp5(dto.getCusp5() == null ? updatedEntity.getCusp5() : dto.getCusp5());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMaxillaMolar2 fields
        updatedEntity.setMetacone(dto.getMetacone() == null ? updatedEntity.getMetacone() : dto.getMetacone());
        updatedEntity.setHypocone(dto.getHypocone() == null ? updatedEntity.getHypocone() : dto.getHypocone());
        updatedEntity.setCarabelli(dto.getCarabelli() == null ? updatedEntity.getCarabelli() : dto.getCarabelli());
        updatedEntity.setC2Parastyle(dto.getC2Parastyle() == null ? updatedEntity.getC2Parastyle() : dto.getC2Parastyle());

        return specificRepository.save(updatedEntity);
    }

}
