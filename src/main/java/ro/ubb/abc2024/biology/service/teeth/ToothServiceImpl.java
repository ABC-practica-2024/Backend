package ro.ubb.abc2024.biology.service.teeth;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.teeth.Tooth;
import ro.ubb.abc2024.biology.dto.teeth.ToothDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ToothServiceImpl<T extends Tooth, D extends ToothDto> implements ToothService<T, D> {

    private final JpaRepository<T, Long> repository;

    @Override
    public T getById(Long id) {
        Optional<T> tooth = repository.findById(id);
        return tooth.orElseThrow(() -> new ResourceNotFoundException("Tooth not found with id " + id));
    }

    @Override
    public T save(T tooth) {
        return repository.save(tooth);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    public T update(Long id, D dto) {
        Optional<T> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found");
        }
        T updatedEntity = optional.get();

        updatedEntity.setToothType(dto.getToothType() == null ? updatedEntity.getToothType() : dto.getToothType());
        updatedEntity.setIsAdult(dto.getIsAdult() == null ? updatedEntity.getIsAdult() : dto.getIsAdult()) ;
        updatedEntity.setSide(dto.getSide() == null ? updatedEntity.getSide() : dto.getSide());
        updatedEntity.setInventoryCondition(dto.getInventoryCondition() == null ? updatedEntity.getInventoryCondition() : dto.getInventoryCondition());
        updatedEntity.setInventory(dto.getInventory() == null ? updatedEntity.getInventory() : dto.getInventory());
        updatedEntity.setDevelopment(dto.getDevelopment() == null ? updatedEntity.getDevelopment() : dto.getDevelopment());
        updatedEntity.setCaries(dto.getCaries() == null ? updatedEntity.getCaries() : dto.getCaries());
        updatedEntity.setAbcesses(dto.getAbcesses() == null ? updatedEntity.getAbcesses() : dto.getAbcesses());
        updatedEntity.setCalculus(dto.getCalculus() == null ? updatedEntity.getCalculus() : dto.getCalculus());
        updatedEntity.setChipping(dto.getChipping() == null ? updatedEntity.getChipping() : dto.getChipping());
        updatedEntity.setAttritionScoreIncisiv(dto.getAttritionScoreIncisiv() == null ? updatedEntity.getAttritionScoreIncisiv() : dto.getAttritionScoreIncisiv());
        updatedEntity.setAttritionScoreCanin(dto.getAttritionScoreCanin() == null ? updatedEntity.getAttritionScoreCanin() : dto.getAttritionScoreCanin());
        updatedEntity.setAttritionScorePreMolar(dto.getAttritionScorePreMolar() == null ? updatedEntity.getAttritionScorePreMolar() : dto.getAttritionScorePreMolar());
        updatedEntity.setAttritionScoreMolar(dto.getAttritionScoreMolar() == null ? updatedEntity.getAttritionScoreMolar() : dto.getAttritionScoreMolar());
        updatedEntity.setMesioBuccal(dto.getMesioBuccal() == null ? updatedEntity.getMesioBuccal() : dto.getMesioBuccal());
        updatedEntity.setMesioLingual(dto.getMesioLingual() == null ? updatedEntity.getMesioLingual() : dto.getMesioLingual());
        updatedEntity.setDistoLingual(dto.getDistoLingual() == null ? updatedEntity.getDistoLingual() : dto.getDistoLingual());
        updatedEntity.setDistoBuccal(dto.getDistoBuccal() == null ? updatedEntity.getDistoBuccal() : dto.getDistoBuccal() );
        updatedEntity.setMdDiameter(dto.getMdDiameter() == null ? updatedEntity.getMdDiameter() : dto.getMdDiameter());
        updatedEntity.setBlDiameter(dto.getBlDiameter() == null ? updatedEntity.getBlDiameter() : dto.getBlDiameter());
        updatedEntity.setCrownHeight(dto.getCrownHeight() == null ? updatedEntity.getCrownHeight() : dto.getCrownHeight());
        updatedEntity.setDefectNoOnTooth(dto.getDefectNoOnTooth() == null ? updatedEntity.getDefectNoOnTooth() : dto.getDefectNoOnTooth());
        updatedEntity.setDefectType(dto.getDefectType() == null ? updatedEntity.getDefectType() : dto.getDefectType() );
        updatedEntity.setDistanceFromCEJ(dto.getDistanceFromCEJ() == null ? updatedEntity.getDistanceFromCEJ() : dto.getDistanceFromCEJ());
        updatedEntity.setColor(dto.getColor() == null ? updatedEntity.getColor() : dto.getColor());
        updatedEntity.setPeriodontitisAdult(dto.getPeriodontitisAdult() == null ? updatedEntity.getPeriodontitisAdult() : dto.getPeriodontitisAdult());
        updatedEntity.setToothHatch(dto.getToothHatch() == null ? updatedEntity.getToothHatch() : dto.getToothHatch() );
        updatedEntity.setToothHatchDescription(dto.getToothHatchDescription() == null ? updatedEntity.getToothHatchDescription() : dto.getToothHatchDescription());
        updatedEntity.setToothInventoryId(dto.getToothInventoryId() == null ? updatedEntity.getToothInventoryId() : dto.getToothInventoryId());

        return repository.save(updatedEntity);
    }

}
