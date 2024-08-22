package ro.ubb.abc2024.biology.service.Extremities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.Phalanges;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.PhalangesRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IPhalangesService;

import java.util.List;
import java.util.Optional;
@Service
public class PhalangesServiceImpl implements IPhalangesService {
    private static final Logger log = LoggerFactory.getLogger(PhalangesServiceImpl.class);

    @Autowired
    private PhalangesRepository phalangesRepository;


    @Override
    public List<Phalanges> getAllPhalanges() {
        log.trace("getAllPhalanges() --- method entered");
        List<Phalanges> phalanges = phalangesRepository.findAll();
        if (phalanges.isEmpty()) {
            log.error("getAllPhalanges() returned empty list");
            throw new DataBaseOperationException("getAllPhalanges() returned empty list");
        } else {
            log.trace("getAllPhalanges(): phalanges.size={}", phalanges.size());
            return phalanges;
        }
    }

    @Override
    public Phalanges getPhalangesById(Long id) {
        log.trace("getPhalangesById() --- method entered");
        Optional<Phalanges> phalangesOptional = phalangesRepository.findById(id);
        if (phalangesOptional.isPresent()) {
            Phalanges phalanges = phalangesOptional.get();
            return phalanges;
        } else {
            log.error("getPhalangesById(): phalanges={} not found", id);
            throw new ResourceNotFoundException("getPhalangesById(): phalanges={} not found");
        }
    }

    @Override
    public Phalanges savePhalanges(Phalanges phalanges) {
        log.trace("savePhalanges() --- method entered");
        try {
            Phalanges savedPhalanges = phalangesRepository.save(phalanges);
            log.trace("savePhalanges(): savedPhalanges={}", savedPhalanges);
            return savedPhalanges;
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving phalanges: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving phalanges: " + e.getMessage());
        }
    }

    @Override
    public Phalanges updatePhalanges(Long id, Phalanges phalanges) {
        log.trace("updatePhalanges() --- method entered");
        Optional<Phalanges> optionalPhalanges = phalangesRepository.findById(id);
        if (optionalPhalanges.isPresent()) {
            Phalanges updatedPhalanges = optionalPhalanges.get();
            updatedPhalanges.setBonesNo(phalanges.getBonesNo());
            updatedPhalanges.setInventoryCondition(phalanges.getInventoryCondition());
            updatedPhalanges.setBoneType(phalanges.getBoneType());

            log.trace("updatePhalanges(): updatedPhalanges={}", updatedPhalanges);
            return phalangesRepository.save(updatedPhalanges);
        } else {
            log.error("updatePhalanges(): phalanges={} not found", phalanges);
            throw new ResourceNotFoundException("Phalanges with ID = " + id + " not found");
        }
    }

    @Override
    public void deletePhalangesById(Long id) {
        log.trace("deletePhalangesById() --- method entered");
        Optional<Phalanges> optionalPhalanges = phalangesRepository.findById(id);
        if (optionalPhalanges.isPresent()) {
            phalangesRepository.delete(optionalPhalanges.get());
            log.trace("deletePhalangesById(): phalanges={}", optionalPhalanges.get());
        } else {
            log.error("deletePhalangesById(): phalanges={} not found", id);
            throw new ResourceNotFoundException("deletePhalangesById(): phalanges={} not found");
        }
    }
}