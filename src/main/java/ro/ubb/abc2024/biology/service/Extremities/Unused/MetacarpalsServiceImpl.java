//package ro.ubb.abc2024.biology.service.Metacarpals;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremity.Metacarpals;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.MetacarpalsRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IMetacarpalsService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MetacarpalsServiceImpl implements IMetacarpalsService {
//    private static final Logger log = LoggerFactory.getLogger(MetacarpalsServiceImpl.class);
//
//    @Autowired
//    private MetacarpalsRepository metacarpalsRepository;
//
//
//    @Override
//    public List<Metacarpals> getAllMetacarpals() {
//        log.trace("getAllMetacarpals() --- method entered");
//        List<Metacarpals> metacarpals = metacarpalsRepository.findAll();
//        return Optional.of(metacarpals)
//                .filter(list -> !list.isEmpty())
//                .orElseThrow(() -> new DataBaseOperationException("getAllMetacarpals() returned empty list"));
//    }
//
//    @Override
//    public Metacarpals getMetacarpalsById(Long id) {
//        log.trace("getMetacarpalsById() --- method entered");
//        return metacarpalsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
//    }
//
//
//    @Override
//    public Metacarpals saveMetacarpals(Metacarpals metacarpals) {
//        log.trace("saveMetacarpals() --- method entered");
//        try {
//            Metacarpals savedMetacarpals = metacarpalsRepository.save(metacarpals);
//            log.trace("saveMetacarpals(): savedMetacarpals={}", savedMetacarpals);
//            return savedMetacarpals;
//        } catch (DataIntegrityViolationException e) {
//            log.error("Error while saving metacarpals: {}", e.getMessage());
//            throw new DataBaseOperationException("Error while saving metacarpals: " + e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public Metacarpals updateMetacarpals(Long id, Metacarpals metacarpals) {
//        log.trace("updateMetacarpals() --- method entered");
//        return metacarpalsRepository.findById(id).map(existingMetacarpals -> {
//            existingMetacarpals.setProximalJuvenileStageOfUnion(metacarpals.getProximalJuvenileStageOfUnion());
//            existingMetacarpals.setDistalJuvenileStageOfUnion(metacarpals.getDistalJuvenileStageOfUnion());
//            existingMetacarpals.setStagesOfDJD(metacarpals.getStagesOfDJD());
//            return metacarpalsRepository.save(existingMetacarpals);
//        }).orElseThrow(() -> new ResourceNotFoundException("Metacarpals with ID = " + id + " not found"));
//    }
//
//    @Override
//    public void deleteMetacarpalsById(Long id) {
//        metacarpalsRepository.delete(
//                metacarpalsRepository.findById(id).orElseThrow(
//                        () -> new ResourceNotFoundException("Metacarpals with ID = " + id + " not found")
//                )
//        );
//    }
//}