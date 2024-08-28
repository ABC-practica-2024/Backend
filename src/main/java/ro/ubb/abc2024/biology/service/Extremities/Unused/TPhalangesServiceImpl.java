//package ro.ubb.abc2024.biology.service.Extremities;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremities.TPhalanges;
//import ro.ubb.abc2024.biology.domain.Extremities.TPhalanges;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.TPhalangesRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ITPhalangesService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TPhalangesServiceImpl implements ITPhalangesService {
//    private static final Logger log = LoggerFactory.getLogger(TPhalangesServiceImpl.class);
//
//    @Autowired
//    private TPhalangesRepository tPhalangesRepository;
//
//    @Override
//    public List<TPhalanges> getAllTPhalanges() {
//        log.trace("getAllTPhalanges() --- method entered");
//        List<TPhalanges> tPhalanges = tPhalangesRepository.findAll();
//        return Optional.of(tPhalanges)
//                .filter(list -> !list.isEmpty())
//                .orElseThrow(() -> new DataBaseOperationException("getAllTPhalanges() returned empty list"));
//    }
//
//    @Override
//    public TPhalanges getTPhalangesById(Long id) {
//        log.trace("getTPhalangesById() --- method entered");
//        return tPhalangesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
//    }
//
//
//    @Override
//    public TPhalanges saveTPhalanges(TPhalanges tPhalanges) {
//        log.trace("saveTPhalanges() --- method entered");
//        try {
//            TPhalanges savedTPhalanges = tPhalangesRepository.save(tPhalanges);
//            log.trace("saveTPhalanges(): savedTPhalanges={}", savedTPhalanges);
//            return savedTPhalanges;
//        } catch (DataIntegrityViolationException e) {
//            log.error("Error while saving tPhalanges: {}", e.getMessage());
//            throw new DataBaseOperationException("Error while saving tPhalanges: " + e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public TPhalanges updateTPhalanges(Long id, TPhalanges tPhalanges) {
//        log.trace("updateTPhalanges() --- method entered");
//        return tPhalangesRepository.findById(id).map(existingTPhalanges -> {
//            existingTPhalanges.setProximalJuvenileStageOfUnion(tPhalanges.getProximalJuvenileStageOfUnion());
//            existingTPhalanges.setPosition(tPhalanges.getPosition());
//            existingTPhalanges.setStagesOfDJD(tPhalanges.getStagesOfDJD());
//            return tPhalangesRepository.save(existingTPhalanges);
//        }).orElseThrow(() -> new ResourceNotFoundException("TPhalanges with ID = " + id + " not found"));
//    }
//
//    @Override
//    public void deleteTPhalangesById(Long id) {
//        tPhalangesRepository.delete(
//                tPhalangesRepository.findById(id).orElseThrow(
//                        () -> new ResourceNotFoundException("TPhalanges with ID = " + id + " not found")
//                )
//        );
//    }
//}
