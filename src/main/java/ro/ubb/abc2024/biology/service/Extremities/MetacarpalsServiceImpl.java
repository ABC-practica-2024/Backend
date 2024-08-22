package ro.ubb.abc2024.biology.service.Extremities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.Metacarpals;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.MetacarpalsRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IMetacarpalsService;

import java.util.List;
import java.util.Optional;

@Service
public class MetacarpalsServiceImpl implements IMetacarpalsService {
    private static final Logger log = LoggerFactory.getLogger(MetacarpalsServiceImpl.class);

    @Autowired
    private MetacarpalsRepository metacarpalsRepository;


    @Override
    public List<Metacarpals> getAllMetacarpals() {
        log.trace("getAllMetacarpals() --- method entered");
        List<Metacarpals> metacarpals = metacarpalsRepository.findAll();
        if (metacarpals.isEmpty()) {
            log.error("getAllMetacarpals() returned empty list");
            throw new DataBaseOperationException("getAllMetacarpals() returned empty list");
        } else {
            log.trace("getAllMetacarpals(): metacarpals.size={}", metacarpals.size());
            return metacarpals;
        }
    }

    @Override
    public Metacarpals getMetacarpalsById(Long id) {
        log.trace("getMetacarpalsById() --- method entered");
        Optional<Metacarpals> metacarpalsOptional = metacarpalsRepository.findById(id);
        if (metacarpalsOptional.isPresent()) {
            Metacarpals metacarpals = metacarpalsOptional.get();
            return metacarpals;
        } else {
            log.error("getMetacarpalsById(): metacarpals={} not found", id);
            throw new ResourceNotFoundException("getMetacarpalsById(): metacarpals={} not found");
        }
    }

    @Override
    public Metacarpals saveMetacarpals(Metacarpals metacarpals) {
        log.trace("saveMetacarpals() --- method entered");
        try {
            Metacarpals savedMetacarpals = metacarpalsRepository.save(metacarpals);
            log.trace("saveMetacarpals(): savedMetacarpals={}", savedMetacarpals);
            return savedMetacarpals;
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving metacarpals: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving metacarpals: " + e.getMessage());
        }
    }

    @Override
    public Metacarpals updateMetacarpals(Long id, Metacarpals metacarpals) {
        log.trace("updateMetacarpals() --- method entered");
        Optional<Metacarpals> optionalMetacarpals = metacarpalsRepository.findById(id);
        if (optionalMetacarpals.isPresent()) {
            Metacarpals updatedMetacarpals = optionalMetacarpals.get();
            updatedMetacarpals.setBonesNo(metacarpals.getBonesNo());
            updatedMetacarpals.setInventoryCondition(metacarpals.getInventoryCondition());
            updatedMetacarpals.setBoneType(metacarpals.getBoneType());

            log.trace("updateMetacarpals(): updatedMetacarpals={}", updatedMetacarpals);
            return metacarpalsRepository.save(updatedMetacarpals);
        } else {
            log.error("updateMetacarpals(): metacarpals={} not found", metacarpals);
            throw new ResourceNotFoundException("Metacarpals with ID = " + id + " not found");
        }
    }

    @Override
    public void deleteMetacarpalsById(Long id) {
        log.trace("deleteMetacarpalsById() --- method entered");
        Optional<Metacarpals> optionalMetacarpals = metacarpalsRepository.findById(id);
        if (optionalMetacarpals.isPresent()) {
            metacarpalsRepository.delete(optionalMetacarpals.get());
            log.trace("deleteMetacarpalsById(): metacarpals={}", optionalMetacarpals.get());
        } else {
            log.error("deleteMetacarpalsById(): metacarpals={} not found", id);
            throw new ResourceNotFoundException("deleteMetacarpalsById(): metacarpals={} not found");
        }
    }
}