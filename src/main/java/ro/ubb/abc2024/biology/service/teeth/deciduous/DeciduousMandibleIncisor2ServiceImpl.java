package ro.ubb.abc2024.biology.service.teeth.deciduous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor2Dto;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.DeciduousMandibleIncisor2Repository;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;

@Service
public class DeciduousMandibleIncisor2ServiceImpl extends ToothServiceImpl<DeciduousMandibleIncisor2, DeciduousMandibleIncisor2Dto> {

    private final DeciduousMandibleIncisor2Repository specificRepository;

    @Autowired
    public DeciduousMandibleIncisor2ServiceImpl(JpaRepository<DeciduousMandibleIncisor2, Long> repository,
                                                DeciduousMandibleIncisor2Repository specificRepository) {
        super(repository);
        this.specificRepository = specificRepository;
    }

    @Override
    public DeciduousMandibleIncisor2 update(Long id, DeciduousMandibleIncisor2Dto dto){
        DeciduousMandibleIncisor2 updatedEntity = super.update(id, dto);

        // DeciduousIncisor fields
        updatedEntity.setShovel(dto.getShovel() == null ? updatedEntity.getShovel() : dto.getShovel());
        updatedEntity.setLabialDefect(dto.getLabialDefect() == null ? updatedEntity.getLabialDefect() : dto.getLabialDefect());
        updatedEntity.setDoubleTeeth(dto.getDoubleTeeth() == null ? updatedEntity.getDoubleTeeth() : dto.getDoubleTeeth());
        // DeciduousMandibleIncisor2 fields
        updatedEntity.setDAR(dto.getDAR() == null ? updatedEntity.getDAR() : dto.getDAR());
        updatedEntity.setRootGroove(dto.getRootGroove() == null ? updatedEntity.getRootGroove() : dto.getRootGroove());

        return specificRepository.save(updatedEntity);
    }
}
