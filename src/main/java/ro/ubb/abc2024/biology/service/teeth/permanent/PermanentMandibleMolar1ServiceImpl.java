package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar1Dto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleMolar1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMandibleMolar1ServiceImpl extends ToothServiceImpl<PermanentMandibleMolar1, PermanentMandibleMolar1Dto> {

    private  final PermanentMandibleMolar1Repository specificRepository;

    @Autowired
    public PermanentMandibleMolar1ServiceImpl(JpaRepository<PermanentMandibleMolar1, Long> repository, PermanentMandibleMolar1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMandibleMolar1 update(Long id, PermanentMandibleMolar1Dto dto){
        PermanentMandibleMolar1 updatedEntity = super.update(id, dto);

        // PermanentMolar fields
        updatedEntity.setCusp5(dto.getCusp5() == null ? updatedEntity.getCusp5() : dto.getCusp5());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMandibleMolar1 fields
        updatedEntity.setAntFovea(dto.getAntFovea() == null ? updatedEntity.getAntFovea() : dto.getAntFovea());
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
