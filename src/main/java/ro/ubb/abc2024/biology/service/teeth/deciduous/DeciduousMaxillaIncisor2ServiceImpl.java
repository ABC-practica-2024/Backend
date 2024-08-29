package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor2Dto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMaxillaIncisor2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMaxillaIncisor2ServiceImpl extends ToothServiceImpl<DeciduousMaxillaIncisor2, DeciduousMaxillaIncisor2Dto> {

    private final DeciduousMaxillaIncisor2Repository specificRepository;

    @Autowired
    public DeciduousMaxillaIncisor2ServiceImpl(JpaRepository<DeciduousMaxillaIncisor2, Long> repository,
                                               DeciduousMaxillaIncisor2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMaxillaIncisor2 update(Long id, DeciduousMaxillaIncisor2Dto dto){
        DeciduousMaxillaIncisor2 updatedEntity = super.update(id, dto);

        // DeciduousIncisor fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setLabialDefect(dto.getLabialDefect() == null ? updatedEntity.getLabialDefect() : dto.getLabialDefect());
        updatedEntity.setDoubleTeeth(dto.getDoubleTeeth() == null ? updatedEntity.getDoubleTeeth() : dto.getDoubleTeeth());
        // DeciduousMaxillaIncisor2 fields
        updatedEntity.setDoubleShovel(dto.getDoubleShovel() == null ? updatedEntity.getDoubleShovel() : dto.getDoubleShovel());
        updatedEntity.setRootSheathGroove(dto.getRootSheathGroove() == null ? updatedEntity.getRootSheathGroove() : dto.getRootSheathGroove());

        return specificRepository.save(updatedEntity);
    }
}
