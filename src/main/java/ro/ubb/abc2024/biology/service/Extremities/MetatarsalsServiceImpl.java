package ro.ubb.abc2024.biology.service.Extremities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.Metatarsals;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.MetatarsalsRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IMetatarsalsService;

import java.util.List;
import java.util.Optional;

@Service
public class MetatarsalsServiceImpl implements IMetatarsalsService {
        private static final Logger log = LoggerFactory.getLogger(MetatarsalsServiceImpl.class);

        @Autowired
        private MetatarsalsRepository metatarsalsRepository;


        @Override
        public List<Metatarsals> getAllMetatarsals() {
                log.trace("getAllMetatarsals() --- method entered");
                List<Metatarsals> metatarsals = metatarsalsRepository.findAll();
                if (metatarsals.isEmpty()) {
                        log.error("getAllMetatarsals() returned empty list");
                        throw new DataBaseOperationException("getAllMetatarsals() returned empty list");
                } else {
                        log.trace("getAllMetatarsals(): metatarsals.size={}", metatarsals.size());
                        return metatarsals;
                }
        }

        @Override
        public Metatarsals getMetatarsalsById(Long id) {
                log.trace("getMetatarsalsById() --- method entered");
                Optional<Metatarsals> metatarsalsOptional = metatarsalsRepository.findById(id);
                if (metatarsalsOptional.isPresent()) {
                        Metatarsals metatarsals = metatarsalsOptional.get();
                        return metatarsals;
                } else {
                        log.error("getMetatarsalsById(): metatarsals={} not found", id);
                        throw new ResourceNotFoundException("getMetatarsalsById(): metatarsals={} not found");
                }
        }

        @Override
        public Metatarsals saveMetatarsals(Metatarsals metatarsals) {
                log.trace("saveMetatarsals() --- method entered");
                try {
                        Metatarsals savedMetatarsals = metatarsalsRepository.save(metatarsals);
                        log.trace("saveMetatarsals(): savedMetatarsals={}", savedMetatarsals);
                        return savedMetatarsals;
                } catch (DataIntegrityViolationException e) {
                        log.error("Error while saving metatarsals: {}", e.getMessage());
                        throw new DataBaseOperationException("Error while saving metatarsals: " + e.getMessage());
                }
        }

        @Override
        public Metatarsals updateMetatarsals(Long id, Metatarsals metatarsals) {
                log.trace("updateMetatarsals() --- method entered");
                Optional<Metatarsals> optionalMetatarsals = metatarsalsRepository.findById(id);
                if (optionalMetatarsals.isPresent()) {
                        Metatarsals updatedMetatarsals = optionalMetatarsals.get();
                        updatedMetatarsals.setBonesNo(metatarsals.getBonesNo());
                        updatedMetatarsals.setInventoryCondition(metatarsals.getInventoryCondition());
                        updatedMetatarsals.setBoneType(metatarsals.getBoneType());

                        log.trace("updateMetatarsals(): updatedMetatarsals={}", updatedMetatarsals);
                        return metatarsalsRepository.save(updatedMetatarsals);
                } else {
                        log.error("updateMetatarsals(): metatarsals={} not found", metatarsals);
                        throw new ResourceNotFoundException("Metatarsals with ID = " + id + " not found");
                }
        }

        @Override
        public void deleteMetatarsalsById(Long id) {
                log.trace("deleteMetatarsalsById() --- method entered");
                Optional<Metatarsals> optionalMetatarsals = metatarsalsRepository.findById(id);
                if (optionalMetatarsals.isPresent()) {
                        metatarsalsRepository.delete(optionalMetatarsals.get());
                        log.trace("deleteMetatarsalsById(): metatarsals={}", optionalMetatarsals.get());
                } else {
                        log.error("deleteMetatarsalsById(): metatarsals={} not found", id);
                        throw new ResourceNotFoundException("deleteMetatarsalsById(): metatarsals={} not found");
                }
        }
}