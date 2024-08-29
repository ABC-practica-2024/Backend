package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor1Dto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaIncisor1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMaxillaIncisor1ServiceImpl extends ToothServiceImpl<DeciduousMaxillaIncisor1, DeciduousMaxillaIncisor1Dto> {

    private final DeciduousMaxillaIncisor1Repository specificRepository;

    @Autowired
    public DeciduousMaxillaIncisor1ServiceImpl(JpaRepository<DeciduousMaxillaIncisor1, Long> repository,
                                               DeciduousMaxillaIncisor1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMaxillaIncisor1 update(Long id, DeciduousMaxillaIncisor1Dto dto){
        DeciduousMaxillaIncisor1 updatedEntity = super.update(id, dto);

        // DeciduousIncisor fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setLabialDefect(dto.getLabialDefect() == null ? updatedEntity.getLabialDefect() : dto.getLabialDefect());
        updatedEntity.setDoubleTeeth(dto.getDoubleTeeth() == null ? updatedEntity.getDoubleTeeth() : dto.getDoubleTeeth());
        // DeciduousMaxillaIncisor1 fields
        updatedEntity.setWinging(dto.getWinging() == null ? updatedEntity.getWinging() : dto.getWinging());
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setRootSheathGroove(dto.getRootSheathGroove() == null ? updatedEntity.getRootSheathGroove() : dto.getRootSheathGroove());

        return specificRepository.save(updatedEntity);
    }
}
