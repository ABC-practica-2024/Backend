package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar2Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleMolar2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMandibleMolar2ServiceImpl extends ToothServiceImpl<PermanentMandibleMolar2, PermanentMandibleMolar2Dto> {

    private  final PermanentMandibleMolar2Repository specificRepository;

    @Autowired
    public PermanentMandibleMolar2ServiceImpl(JpaRepository<PermanentMandibleMolar2, Long> repository,
                                              PermanentMandibleMolar2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMandibleMolar2 update(Long id, PermanentMandibleMolar2Dto dto){
        PermanentMandibleMolar2 updatedEntity = super.update(id, dto);

        // PermanentMolar fields
        updatedEntity.setCusp5(dto.getCusp5() == null ? updatedEntity.getCusp5() : dto.getCusp5());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMandibleMolar1 fields
        updatedEntity.setGroovePattern(dto.getGroovePattern() == null ? updatedEntity.getGroovePattern() : dto.getGroovePattern());
        updatedEntity.setCuspNumber(dto.getCuspNumber() == null ? updatedEntity.getCuspNumber() : dto.getCuspNumber());
        updatedEntity.setDeflectingWrinkle(dto.getDeflectingWrinkle() == null ? updatedEntity.getDeflectingWrinkle() : dto.getDeflectingWrinkle());
        updatedEntity.setMidTrigonidCrest(dto.getMidTrigonidCrest() == null ? updatedEntity.getMidTrigonidCrest() : dto.getMidTrigonidCrest());
        updatedEntity.setDistalTrigonidCrest(dto.getDistalTrigonidCrest() == null ? updatedEntity.getDistalTrigonidCrest() : dto.getDistalTrigonidCrest());
        updatedEntity.setProtstylid(dto.getProtstylid() == null ? updatedEntity.getProtstylid() : dto.getProtstylid());
        updatedEntity.setCusp6(dto.getCusp6() == null ? updatedEntity.getCusp6() : dto.getCusp6());
        updatedEntity.setCusp7(dto.getCusp7() == null ? updatedEntity.getCusp7() : dto.getCusp7());

        return specificRepository.save(updatedEntity);
    }

}
