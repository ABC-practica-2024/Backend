package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar3Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaMolar3Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMaxillaMolar3ServiceImpl extends ToothServiceImpl<PermanentMaxillaMolar3, PermanentMaxillaMolar3Dto> {

    private  final PermanentMaxillaMolar3Repository specificRepository;

    @Autowired
    public PermanentMaxillaMolar3ServiceImpl(JpaRepository<PermanentMaxillaMolar3, Long> repository,
                                             PermanentMaxillaMolar3Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMaxillaMolar3 update(Long id, PermanentMaxillaMolar3Dto dto){
        PermanentMaxillaMolar3 updatedEntity = super.update(id, dto);

        // PermanentMolar fields
        updatedEntity.setCusp5(dto.getCusp5() == null ? updatedEntity.getCusp5() : dto.getCusp5());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMaxillaMolar3 fields
        updatedEntity.setMetacone(dto.getMetacone() == null ? updatedEntity.getMetacone() : dto.getMetacone());
        updatedEntity.setHypocone(dto.getHypocone() == null ? updatedEntity.getHypocone() : dto.getHypocone());
        updatedEntity.setCarabelli(dto.getCarabelli() == null ? updatedEntity.getCarabelli() : dto.getCarabelli());
        updatedEntity.setC2Parastyle(dto.getC2Parastyle() == null ? updatedEntity.getC2Parastyle() : dto.getC2Parastyle());
        updatedEntity.setPegReduced(dto.getPegReduced() == null ? updatedEntity.getPegReduced() : dto.getPegReduced());
        updatedEntity.setCongAbsence(dto.getCongAbsence() == null ? updatedEntity.getCongAbsence() : dto.getCongAbsence());

        return specificRepository.save(updatedEntity);
    }

}
