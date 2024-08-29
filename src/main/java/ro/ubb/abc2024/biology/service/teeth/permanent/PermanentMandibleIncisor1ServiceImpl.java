package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor1Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleIncisor1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMandibleIncisor1ServiceImpl extends ToothServiceImpl<PermanentMandibleIncisor1, PermanentMandibleIncisor1Dto> {

    private final PermanentMandibleIncisor1Repository specificRepository;

    @Autowired
    public PermanentMandibleIncisor1ServiceImpl(JpaRepository<PermanentMandibleIncisor1, Long> repository,
                                                PermanentMandibleIncisor1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMandibleIncisor1 update(Long id, PermanentMandibleIncisor1Dto dto){
        PermanentMandibleIncisor1 updatedEntity = super.update(id, dto);

        // PermanentIncisor fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMandibleIncisor1 fields
        updatedEntity.setCongAbsence(dto.getCongAbsence() == null ? updatedEntity.getCongAbsence() : dto.getCongAbsence());

        return specificRepository.save(updatedEntity);
    }
}
