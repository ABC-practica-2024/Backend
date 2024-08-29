package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor1Dto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMandibleIncisor1Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMandibleIncisor1ServiceImpl extends ToothServiceImpl<DeciduousMandibleIncisor1, DeciduousMandibleIncisor1Dto> {

    private final DeciduousMandibleIncisor1Repository specificRepository;

    @Autowired
    public DeciduousMandibleIncisor1ServiceImpl(JpaRepository<DeciduousMandibleIncisor1, Long> repository,
                                                DeciduousMandibleIncisor1Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMandibleIncisor1 update(Long id, DeciduousMandibleIncisor1Dto dto){
        DeciduousMandibleIncisor1 updatedEntity = super.update(id, dto);

        // DeciduousIncisor fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setLabialDefect(dto.getLabialDefect() == null ? updatedEntity.getLabialDefect() : dto.getLabialDefect());
        updatedEntity.setDoubleTeeth(dto.getDoubleTeeth() == null ? updatedEntity.getDoubleTeeth() : dto.getDoubleTeeth());
        // DeciduousMandibleIncisor1 fields
        updatedEntity.setDAR(dto.getDAR() == null ? updatedEntity.getDAR() : dto.getDAR());
        updatedEntity.setRootGroove(dto.getRootGroove() == null ? updatedEntity.getRootGroove() : dto.getRootGroove());

        return specificRepository.save(updatedEntity);
    }
}
