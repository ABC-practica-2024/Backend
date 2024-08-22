package ro.ubb.abc2024.biology.service.Extremities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.CPhalanges;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.CPhalangesRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICPhalangesService;

import java.util.List;
import java.util.Optional;
@Service
public class CPhalangesServiceImpl implements ICPhalangesService {
    private static final Logger log = LoggerFactory.getLogger(CPhalangesServiceImpl.class);

    @Autowired
    private CPhalangesRepository cPhalangesRepository;


    @Override
    public List<CPhalanges> getAllCPhalanges() {
        log.trace("getAllCPhalanges() --- method entered");
        List<CPhalanges> cPhalanges = cPhalangesRepository.findAll();
        if (cPhalanges.isEmpty()) {
            log.error("getAllCPhalanges() returned empty list");
            throw new DataBaseOperationException("getAllCPhalanges() returned empty list");
        } else {
            log.trace("getAllCPhalanges(): cPhalanges.size={}", cPhalanges.size());
            return cPhalanges;
        }
    }

    @Override
    public CPhalanges getCPhalangesById(Long id) {
        log.trace("getCPhalangesById() --- method entered");
        Optional<CPhalanges> cPhalangesOptional = cPhalangesRepository.findById(id);
        if (cPhalangesOptional.isPresent()) {
            CPhalanges cPhalanges = cPhalangesOptional.get();
            return cPhalanges;
        } else {
            log.error("getCPhalangesById(): cPhalanges={} not found", id);
            throw new ResourceNotFoundException("getCPhalangesById(): cPhalanges={} not found");
        }
    }

    @Override
    public CPhalanges saveCPhalanges(CPhalanges cPhalanges) {
        log.trace("saveCPhalanges() --- method entered");
        try {
            CPhalanges savedCPhalanges = cPhalangesRepository.save(cPhalanges);
            log.trace("saveCPhalanges(): savedCPhalanges={}", savedCPhalanges);
            return savedCPhalanges;
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving cPhalanges: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving cPhalanges: " + e.getMessage());
        }
    }

    @Override
    public CPhalanges updateCPhalanges(Long id, CPhalanges cPhalanges) {
        log.trace("updateCPhalanges() --- method entered");
        Optional<CPhalanges> optionalCPhalanges = cPhalangesRepository.findById(id);
        if (optionalCPhalanges.isPresent()) {
            CPhalanges updatedCPhalanges = optionalCPhalanges.get();
            updatedCPhalanges.setBonesNo(cPhalanges.getBonesNo());
            updatedCPhalanges.setInventoryCondition(cPhalanges.getInventoryCondition());
            updatedCPhalanges.setBoneType(cPhalanges.getBoneType());

            log.trace("updateCPhalanges(): updatedCPhalanges={}", updatedCPhalanges);
            return cPhalangesRepository.save(updatedCPhalanges);
        } else {
            log.error("updateCPhalanges(): cPhalanges={} not found", cPhalanges);
            throw new ResourceNotFoundException("CPhalanges with ID = " + id + " not found");
        }
    }

    @Override
    public void deleteCPhalangesById(Long id) {
        log.trace("deleteCPhalangesById() --- method entered");
        Optional<CPhalanges> optionalCPhalanges = cPhalangesRepository.findById(id);
        if (optionalCPhalanges.isPresent()) {
            cPhalangesRepository.delete(optionalCPhalanges.get());
            log.trace("deleteCPhalangesById(): cPhalanges={}", optionalCPhalanges.get());
        } else {
            log.error("deleteCPhalangesById(): cPhalanges={} not found", id);
            throw new ResourceNotFoundException("deleteCPhalangesById(): cPhalanges={} not found");
        }
    }
}