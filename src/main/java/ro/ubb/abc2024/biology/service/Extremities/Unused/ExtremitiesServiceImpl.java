//package ro.ubb.abc2024.biology.service.Extremities;
//
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremities.Extremities;
//import ro.ubb.abc2024.biology.domain.Extremities.Extremities;
//import org.springframework.dao.DataIntegrityViolationException;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.ExtremitiesRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IExtremitiesService;
//
//@Service
//public class ExtremitiesServiceImpl implements IExtremitiesService {
//    private static final Logger log = LoggerFactory.getLogger(ExtremitiesServiceImpl.class);
//
//    @Autowired
//    private ExtremitiesRepository extremityRepository;
//
//
//    @Override
//    public List<Extremities> getAllExtremities() {
//        log.trace("getAllExtremities() --- method entered");
//        List<Extremities> extremity = extremityRepository.findAll();
//        return Optional.of(extremity)
//                .filter(list -> !list.isEmpty())
//                .orElseThrow(() -> new DataBaseOperationException("getAllExtremities() returned empty list"));
//    }
//
//    @Override
//    public Extremities getExtremitiesById(Long id) {
//        log.trace("getExtremitiesById() --- method entered");
//        return extremitiesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
//    }
//
//
//    @Override
//    public Extremities saveExtremities(Extremities extremities) {
//        log.trace("saveExtremities() --- method entered");
//        try {
//            Extremities savedExtremities = extremitiesRepository.save(extremities);
//            log.trace("saveExtremities(): savedExtremities={}", savedExtremities);
//            return savedExtremities;
//        } catch (DataIntegrityViolationException e) {
//            log.error("Error while saving extremities: {}", e.getMessage());
//            throw new DataBaseOperationException("Error while saving extremities: " + e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public Extremities updateExtremities(Long id, Extremities extremities) {
//        log.trace("updateExtremities() --- method entered");
//        return extremitiesRepository.findById(id).map(existingExtremities -> {
//            existingExtremities.setBonesNo(extremities.getBonesNo());
//            existingExtremities.setInventoryCondition(extremities.getInventoryCondition());
//            existingExtremities.setBoneType(extremities.getBoneType());
//            return extremitiesRepository.save(existingExtremities);
//        }).orElseThrow(() -> new ResourceNotFoundException("Extremities with ID = " + id + " not found"));
//    }
//
//    @Override
//    public void deleteExtremitiesById(Long id) {
//        extremitiesRepository.delete(
//                extremitiesRepository.findById(id).orElseThrow(
//                        () -> new ResourceNotFoundException("Extremities with ID = " + id + " not found")
//                )
//        );
//    }
//}
