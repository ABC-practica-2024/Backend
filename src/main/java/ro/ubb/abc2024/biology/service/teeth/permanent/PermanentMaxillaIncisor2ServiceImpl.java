package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor2Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaIncisor2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMaxillaIncisor2ServiceImpl extends ToothServiceImpl<PermanentMaxillaIncisor2, PermanentMaxillaIncisor2Dto> {

    private final PermanentMaxillaIncisor2Repository specificRepository;

    @Autowired
    public PermanentMaxillaIncisor2ServiceImpl(JpaRepository<PermanentMaxillaIncisor2, Long> repository,
                                               PermanentMaxillaIncisor2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMaxillaIncisor2 update(Long id, PermanentMaxillaIncisor2Dto dto){
        PermanentMaxillaIncisor2 updatedEntity = super.update(id, dto);

        // PermanentIncisor fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMaxillaIncisor2 fields
        updatedEntity.setLabialCurve(dto.getLabialCurve() == null ? updatedEntity.getLabialCurve() : dto.getLabialCurve());
        updatedEntity.setInterruptGroove(dto.getInterruptGroove() == null ? updatedEntity.getInterruptGroove() : dto.getInterruptGroove());
        updatedEntity.setTuberculumDentale(dto.getTuberculumDentale() == null ? updatedEntity.getTuberculumDentale() : dto.getTuberculumDentale());
        updatedEntity.setPegReduced(dto.getPegReduced() == null ? updatedEntity.getPegReduced() : dto.getPegReduced());
        updatedEntity.setCongAbsence(dto.getCongAbsence() == null ? updatedEntity.getCongAbsence() : dto.getCongAbsence());

        return specificRepository.save(updatedEntity);
    }
}
