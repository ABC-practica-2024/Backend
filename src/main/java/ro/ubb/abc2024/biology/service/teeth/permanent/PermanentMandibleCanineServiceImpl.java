package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleCanineDto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMandibleCanineRepository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMandibleCanineServiceImpl extends ToothServiceImpl<PermanentMandibleCanine, PermanentMandibleCanineDto> {

    private final PermanentMandibleCanineRepository specificRepository;

    @Autowired
    public PermanentMandibleCanineServiceImpl(JpaRepository<PermanentMandibleCanine, Long> repository,
                                              PermanentMandibleCanineRepository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMandibleCanine update(Long id, PermanentMandibleCanineDto dto){
        PermanentMandibleCanine updatedEntity = super.update(id, dto);

        // PermanentCanine fields
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMandibleCanine fields
        updatedEntity.setDistalAccessRidge(dto.getDistalAccessRidge() == null ? updatedEntity.getDistalAccessRidge() : dto.getDistalAccessRidge());
        updatedEntity.setEnamelExt(dto.getEnamelExt() == null ? updatedEntity.getEnamelExt() : dto.getEnamelExt());

        return specificRepository.save(updatedEntity);
    }
}
