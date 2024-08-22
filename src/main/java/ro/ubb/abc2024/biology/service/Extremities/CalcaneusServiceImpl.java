package ro.ubb.abc2024.biology.service.Extremities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.CalcaneusRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICalcaneusService;

import java.util.List;
import java.util.Optional;

@Service
public class CalcaneusServiceImpl implements ICalcaneusService {
    private static final Logger log = LoggerFactory.getLogger(CalcaneusServiceImpl.class);

    @Autowired
    private CalcaneusRepository calcaneusRepository;


    @Override
    public List<Calcaneus> getAllCalcanei() {
        log.trace("getAllCalcaneus() --- method entered");
        List<Calcaneus> calcaneus = calcaneusRepository.findAll();
        if (calcaneus.isEmpty()) {
            log.error("getAllCalcaneus() returned empty list");
            throw new DataBaseOperationException("getAllCalcaneus() returned empty list");
        } else {
            log.trace("getAllCalcaneus(): calcaneus.size={}", calcaneus.size());
            return calcaneus;
        }
    }

    @Override
    public Calcaneus getCalcaneusById(Long id) {
        log.trace("getCalcaneusById() --- method entered");
        Optional<Calcaneus> calcaneusOptional = calcaneusRepository.findById(id);
        if (calcaneusOptional.isPresent()) {
            Calcaneus calcaneus = calcaneusOptional.get();
            return calcaneus;
        } else {
            log.error("getCalcaneusById(): calcaneus={} not found", id);
            throw new ResourceNotFoundException("getCalcaneusById(): calcaneus={} not found");
        }
    }


    @Override
    public Calcaneus saveCalcaneus(Calcaneus calcaneus) {
        log.trace("saveCalcaneus() --- method entered");
        try {
            Calcaneus savedCalcaneus = calcaneusRepository.save(calcaneus);
            log.trace("saveCalcaneus(): savedCalcaneus={}", savedCalcaneus);
            return savedCalcaneus;
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving calcaneus: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving calcaneus: " + e.getMessage());
        }
    }

    @Override
    public Calcaneus updateCalcaneus(Long id, Calcaneus calcaneus) {
        log.trace("updateCalcaneus() --- method entered");
        Optional<Calcaneus> optionalCalcaneus = calcaneusRepository.findById(id);
        if (optionalCalcaneus.isPresent()) {
            Calcaneus updatedCalcaneus = optionalCalcaneus.get();
            updatedCalcaneus.setMaxLength(calcaneus.getMaxLength());
            updatedCalcaneus.setMiddleBreadth(calcaneus.getMiddleBreadth());

            log.trace("updateCalcaneus(): updatedCalcaneus={}", updatedCalcaneus);
            return calcaneusRepository.save(updatedCalcaneus);
        } else {
            log.error("updateCalcaneus(): calcaneus={} not found", calcaneus);
            throw new ResourceNotFoundException("Calcaneus with ID = " + id + " not found");
        }
    }

    @Override
    public void deleteCalcaneusById(Long id) {
        log.trace("deleteCalcaneusById() --- method entered");
        Optional<Calcaneus> optionalCalcaneus = calcaneusRepository.findById(id);
        if (optionalCalcaneus.isPresent()) {
            calcaneusRepository.delete(optionalCalcaneus.get());
            log.trace("deleteCalcaneusById(): calcaneus={}", optionalCalcaneus.get());
        } else {
            log.error("deleteCalcaneusById(): calcaneus={} not found", id);
            throw new ResourceNotFoundException("deleteCalcaneusById(): calcaneus={} not found");
        }
    }
}
