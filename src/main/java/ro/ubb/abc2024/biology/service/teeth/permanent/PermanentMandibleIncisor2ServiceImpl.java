package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor2Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleIncisor2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMandibleIncisor2ServiceImpl extends ToothServiceImpl<PermanentMandibleIncisor2, PermanentMandibleIncisor2Dto> {

    private final PermanentMandibleIncisor2Repository specificRepository;

    @Autowired
    public PermanentMandibleIncisor2ServiceImpl(JpaRepository<PermanentMandibleIncisor2, Long> repository,
                                                PermanentMandibleIncisor2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMandibleIncisor2 update(Long id, PermanentMandibleIncisor2Dto dto){
        PermanentMandibleIncisor2 updatedEntity = super.update(id, dto);

        // PermanentIncisor fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMandibleIncisor2 fields
        // there are no suplimentary fields
        return specificRepository.save(updatedEntity);
    }
}
