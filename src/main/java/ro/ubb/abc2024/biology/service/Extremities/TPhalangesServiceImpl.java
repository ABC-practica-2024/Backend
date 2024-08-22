package ro.ubb.abc2024.biology.service.Extremities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.TPhalanges;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.TPhalangesRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ITPhalangesService;

import java.util.List;
import java.util.Optional;

@Service
public class TPhalangesServiceImpl implements ITPhalangesService {
    private static final Logger log = LoggerFactory.getLogger(TPhalangesServiceImpl.class);

    @Autowired
    private TPhalangesRepository tPhalangesRepository;


    @Override
    public List<TPhalanges> getAllTPhalanges() {
        log.trace("getAllTPhalanges() --- method entered");
        List<TPhalanges> tPhalanges = tPhalangesRepository.findAll();
        if (tPhalanges.isEmpty()) {
            log.error("getAllTPhalanges() returned empty list");
            throw new DataBaseOperationException("getAllTPhalanges() returned empty list");
        } else {
            log.trace("getAllTPhalanges(): tPhalanges.size={}", tPhalanges.size());
            return tPhalanges;
        }
    }

    @Override
    public TPhalanges getTPhalangesById(Long id) {
        log.trace("getTPhalangesById() --- method entered");
        Optional<TPhalanges> tPhalangesOptional = tPhalangesRepository.findById(id);
        if (tPhalangesOptional.isPresent()) {
            TPhalanges tPhalanges = tPhalangesOptional.get();
            return tPhalanges;
        } else {
            log.error("getTPhalangesById(): tPhalanges={} not found", id);
            throw new ResourceNotFoundException("getTPhalangesById(): tPhalanges={} not found");
        }
    }

    @Override
    public TPhalanges saveTPhalanges(TPhalanges tPhalanges) {
        log.trace("saveTPhalanges() --- method entered");
        try {
            TPhalanges savedTPhalanges = tPhalangesRepository.save(tPhalanges);
            log.trace("saveTPhalanges(): savedTPhalanges={}", savedTPhalanges);
            return savedTPhalanges;
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving tPhalanges: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving tPhalanges: " + e.getMessage());
        }
    }

    @Override
    public TPhalanges updateTPhalanges(Long id, TPhalanges tPhalanges) {
        log.trace("updateTPhalanges() --- method entered");
        Optional<TPhalanges> optionalTPhalanges = tPhalangesRepository.findById(id);
        if (optionalTPhalanges.isPresent()) {
            TPhalanges updatedTPhalanges = optionalTPhalanges.get();
            updatedTPhalanges.setBonesNo(tPhalanges.getBonesNo());
            updatedTPhalanges.setInventoryCondition(tPhalanges.getInventoryCondition());
            updatedTPhalanges.setBoneType(tPhalanges.getBoneType());

            log.trace("updateTPhalanges(): updatedTPhalanges={}", updatedTPhalanges);
            return tPhalangesRepository.save(updatedTPhalanges);
        } else {
            log.error("updateTPhalanges(): tPhalanges={} not found", tPhalanges);
            throw new ResourceNotFoundException("TPhalanges with ID = " + id + " not found");
        }
    }

    @Override
    public void deleteTPhalangesById(Long id) {
        log.trace("deleteTPhalangesById() --- method entered");
        Optional<TPhalanges> optionalTPhalanges = tPhalangesRepository.findById(id);
        if (optionalTPhalanges.isPresent()) {
            tPhalangesRepository.delete(optionalTPhalanges.get());
            log.trace("deleteTPhalangesById(): tPhalanges={}", optionalTPhalanges.get());
        } else {
            log.error("deleteTPhalangesById(): tPhalanges={} not found", id);
            throw new ResourceNotFoundException("deleteTPhalangesById(): tPhalanges={} not found");
        }
    }
}
