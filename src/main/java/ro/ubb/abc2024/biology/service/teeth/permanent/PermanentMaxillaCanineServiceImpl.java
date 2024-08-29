package ro.ubb.abc2024.biology.service.teeth.permanent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaCanineDto;
import ro.ubb.abc2024.biology.repository.teeth.permanent.PermanentMaxillaCanineRepository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class PermanentMaxillaCanineServiceImpl extends ToothServiceImpl<PermanentMaxillaCanine, PermanentMaxillaCanineDto> {

    private final PermanentMaxillaCanineRepository specificRepository;

    @Autowired
    public PermanentMaxillaCanineServiceImpl(JpaRepository<PermanentMaxillaCanine, Long> repository,
                                             PermanentMaxillaCanineRepository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public PermanentMaxillaCanine update(Long id, PermanentMaxillaCanineDto dto){
        PermanentMaxillaCanine updatedEntity = super.update(id, dto);

        // PermanentCanine fields
        updatedEntity.setRootNumber(dto.getRootNumber() == null ? updatedEntity.getRootNumber() : dto.getRootNumber());
        updatedEntity.setRadicalNumber(dto.getRadicalNumber() == null ? updatedEntity.getRadicalNumber() : dto.getRadicalNumber());
        // PermanentMaxillaCanine fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel() );
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setTuberculumDentale(dto.getTuberculumDentale() == null ? updatedEntity.getTuberculumDentale() : dto.getTuberculumDentale());
        updatedEntity.setAccessCusps(dto.getAccessCusps() == null ? updatedEntity.getAccessCusps() : dto.getAccessCusps());
        updatedEntity.setAccessRidges(dto.getAccessRidges() == null ? updatedEntity.getAccessRidges() : dto.getAccessRidges());

        return specificRepository.save(updatedEntity);
    }
}
