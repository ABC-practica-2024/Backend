package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaCanineDto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaCanineRepository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMaxillaCanineServiceImpl extends ToothServiceImpl<DeciduousMaxillaCanine, DeciduousMaxillaCanineDto> {

    private final DeciduousMaxillaCanineRepository specificRepository;

    @Autowired
    public DeciduousMaxillaCanineServiceImpl(JpaRepository<DeciduousMaxillaCanine, Long> repository,
                                             DeciduousMaxillaCanineRepository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMaxillaCanine update(Long id, DeciduousMaxillaCanineDto dto){
        DeciduousMaxillaCanine updatedEntity = super.update(id, dto);

        // DeciduousMaxillaCanine fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setDoubleTeeth(dto.getDoubleTeeth() == null ? updatedEntity.getDoubleTeeth() : dto.getDoubleTeeth());
        updatedEntity.setLabialDefect(dto.getLabialDefect() == null ? updatedEntity.getLabialDefect() : dto.getLabialDefect());
        updatedEntity.setCanineForm(dto.getCanineForm() == null ? updatedEntity.getCanineForm() : dto.getCanineForm());
        updatedEntity.setRootSheathGroove(dto.getRootSheathGroove() == null ? updatedEntity.getRootSheathGroove() : dto.getRootSheathGroove());
        updatedEntity.setDAR(dto.getDAR() == null ? updatedEntity.getDAR() : dto.getDAR());

        return specificRepository.save(updatedEntity);
    }
}
