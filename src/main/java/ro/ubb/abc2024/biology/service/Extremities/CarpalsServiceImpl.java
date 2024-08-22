package ro.ubb.abc2024.biology.service.Extremities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.CarpalsRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICarpalsService;

import java.util.List;
import java.util.Optional;

@Service
public class CarpalsServiceImpl implements ICarpalsService {
    private static final Logger log = LoggerFactory.getLogger(CarpalsServiceImpl.class);

    @Autowired
    private CarpalsRepository carpalsRepository;


    @Override
    public List<Carpals> getAllCarpals() {
        log.trace("getAllCarpals() --- method entered");
        List<Carpals> carpals = carpalsRepository.findAll();
        if (carpals.isEmpty()) {
            log.error("getAllCarpals() returned empty list");
            throw new DataBaseOperationException("getAllCarpals() returned empty list");
        } else {
            log.trace("getAllCarpals(): carpals.size={}", carpals.size());
            return carpals;
        }
    }

    @Override
    public Carpals getCarpalsById(Long id) {
        log.trace("getCarpalsById() --- method entered");
        Optional<Carpals> carpalsOptional = carpalsRepository.findById(id);
        if (carpalsOptional.isPresent()) {
            Carpals carpals = carpalsOptional.get();
            return carpals;
        } else {
            log.error("getCarpalsById(): carpals={} not found", id);
            throw new ResourceNotFoundException("getCarpalsById(): carpals={} not found");
        }
    }

    @Override
    public Carpals saveCarpals(Carpals carpals) {
        log.trace("saveCarpals() --- method entered");
        try {
            Carpals savedCarpals = carpalsRepository.save(carpals);
            log.trace("saveCarpals(): savedCarpals={}", savedCarpals);
            return savedCarpals;
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving carpals: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving carpals: " + e.getMessage());
        }
    }

    @Override
    public Carpals updateCarpals(Long id, Carpals carpals) {
        log.trace("updateCarpals() --- method entered");
        Optional<Carpals> optionalCarpals = carpalsRepository.findById(id);
        if (optionalCarpals.isPresent()) {
            Carpals updatedCarpals = optionalCarpals.get();
            updatedCarpals.setBonesNo(carpals.getBonesNo());
            updatedCarpals.setInventoryCondition(carpals.getInventoryCondition());
            updatedCarpals.setBoneType(carpals.getBoneType());

            log.trace("updateCarpals(): updatedCarpals={}", updatedCarpals);
            return carpalsRepository.save(updatedCarpals);
        } else {
            log.error("updateCarpals(): carpals={} not found", carpals);
            throw new ResourceNotFoundException("Carpals with ID = " + id + " not found");
        }
    }

    @Override
    public void deleteCarpalsById(Long id) {
        log.trace("deleteCarpalsById() --- method entered");
        Optional<Carpals> optionalCarpals = carpalsRepository.findById(id);
        if (optionalCarpals.isPresent()) {
            carpalsRepository.delete(optionalCarpals.get());
            log.trace("deleteCarpalsById(): carpals={}", optionalCarpals.get());
        } else {
            log.error("deleteCarpalsById(): carpals={} not found", id);
            throw new ResourceNotFoundException("deleteCarpalsById(): carpals={} not found");
        }
    }
}