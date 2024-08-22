package ro.ubb.abc2024.biology.service.Extremities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.OtherTarsals;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.OtherTarsalsRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IOtherTarsalsService;

import java.util.List;
import java.util.Optional;

@Service
public class OtherTarsalsServiceImpl implements IOtherTarsalsService {
    private static final Logger log = LoggerFactory.getLogger(OtherTarsalsServiceImpl.class);

    @Autowired
    private OtherTarsalsRepository otherTarsalsRepository;


    @Override
    public List<OtherTarsals> getAllOtherTarsals() {
        log.trace("getAllOtherTarsals() --- method entered");
        List<OtherTarsals> otherTarsals = otherTarsalsRepository.findAll();
        if (otherTarsals.isEmpty()) {
            log.error("getAllOtherTarsals() returned empty list");
            throw new DataBaseOperationException("getAllOtherTarsals() returned empty list");
        } else {
            log.trace("getAllOtherTarsals(): otherTarsals.size={}", otherTarsals.size());
            return otherTarsals;
        }
    }

    @Override
    public OtherTarsals getOtherTarsalsById(Long id) {
        log.trace("getOtherTarsalsById() --- method entered");
        Optional<OtherTarsals> otherTarsalsOptional = otherTarsalsRepository.findById(id);
        if (otherTarsalsOptional.isPresent()) {
            OtherTarsals otherTarsals = otherTarsalsOptional.get();
            return otherTarsals;
        } else {
            log.error("getOtherTarsalsById(): otherTarsals={} not found", id);
            throw new ResourceNotFoundException("getOtherTarsalsById(): otherTarsals={} not found");
        }
    }

    @Override
    public OtherTarsals saveOtherTarsals(OtherTarsals otherTarsals) {
        log.trace("saveOtherTarsals() --- method entered");
        try {
            OtherTarsals savedOtherTarsals = otherTarsalsRepository.save(otherTarsals);
            log.trace("saveOtherTarsals(): savedOtherTarsals={}", savedOtherTarsals);
            return savedOtherTarsals;
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving otherTarsals: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving otherTarsals: " + e.getMessage());
        }
    }

    @Override
    public OtherTarsals updateOtherTarsals(Long id, OtherTarsals otherTarsals) {
        log.trace("updateOtherTarsals() --- method entered");
        Optional<OtherTarsals> optionalOtherTarsals = otherTarsalsRepository.findById(id);
        if (optionalOtherTarsals.isPresent()) {
            OtherTarsals updatedOtherTarsals = optionalOtherTarsals.get();
            updatedOtherTarsals.setBonesNo(otherTarsals.getBonesNo());
            updatedOtherTarsals.setInventoryCondition(otherTarsals.getInventoryCondition());
            updatedOtherTarsals.setBoneType(otherTarsals.getBoneType());

            log.trace("updateOtherTarsals(): updatedOtherTarsals={}", updatedOtherTarsals);
            return otherTarsalsRepository.save(updatedOtherTarsals);
        } else {
            log.error("updateOtherTarsals(): otherTarsals={} not found", otherTarsals);
            throw new ResourceNotFoundException("OtherTarsals with ID = " + id + " not found");
        }
    }

    @Override
    public void deleteOtherTarsalsById(Long id) {
        log.trace("deleteOtherTarsalsById() --- method entered");
        Optional<OtherTarsals> optionalOtherTarsals = otherTarsalsRepository.findById(id);
        if (optionalOtherTarsals.isPresent()) {
            otherTarsalsRepository.delete(optionalOtherTarsals.get());
            log.trace("deleteOtherTarsalsById(): otherTarsals={}", optionalOtherTarsals.get());
        } else {
            log.error("deleteOtherTarsalsById(): otherTarsals={} not found", id);
            throw new ResourceNotFoundException("deleteOtherTarsalsById(): otherTarsals={} not found");
        }
    }
}