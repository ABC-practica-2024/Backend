package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor1Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaIncisor1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMaxillaIncisor1ServiceImpl extends ToothServiceImpl<PermanentMaxillaIncisor1, PermanentMaxillaIncisor1Dto> {

    private final PermanentMaxillaIncisor1Repository specificRepository;

    @Autowired
    public PermanentMaxillaIncisor1ServiceImpl(JpaRepository<PermanentMaxillaIncisor1, Long> repository,
                                               PermanentMaxillaIncisor1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMaxillaIncisor1 update(Long id, PermanentMaxillaIncisor1Dto dto){
        PermanentMaxillaIncisor1 updatedEntity = super.update(id, dto);

        // PermanentIncisor fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMaxillaIncisor1 fields
        updatedEntity.setWinging(dto.getWinging() == null ? updatedEntity.getWinging() : dto.getWinging());
        updatedEntity.setLabialCurve(dto.getLabialCurve() == null ? updatedEntity.getLabialCurve() : dto.getLabialCurve());
        updatedEntity.setInterruptGroove(dto.getInterruptGroove() == null ? updatedEntity.getInterruptGroove() : dto.getInterruptGroove());
        updatedEntity.setTuberculumDentale(dto.getTuberculumDentale() == null ? updatedEntity.getTuberculumDentale() : dto.getTuberculumDentale());

        return specificRepository.save(updatedEntity);
    }
}
