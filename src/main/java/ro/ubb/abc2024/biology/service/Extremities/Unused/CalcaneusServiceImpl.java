package ro.ubb.abc2024.biology.service.Extremities.Unused;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.CalcaneusRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICalcaneusService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CalcaneusServiceImpl implements ICalcaneusService {
//    private static final Logger log = LoggerFactory.getLogger(CalcaneusServiceImpl.class);
//
////    @Autowired
////    private CalcaneusRepository calcaneusRepository;
////
////
////    @Override
////    public List<Calcaneus> getAllCalcanei() {
////        log.trace("getAllCalcaneus() --- method entered");
////        List<Calcaneus> calcaneus = calcaneusRepository.findAll();
////        return Optional.of(calcaneus)
////                .filter(list -> !list.isEmpty())
////                .orElseThrow(() -> new DataBaseOperationException("getAllCalcaneus() returned empty list"));
////    }
////
////    @Override
////    public Calcaneus getCalcaneusById(Long id) {
////        log.trace("getCalcaneusById() --- method entered");
////        return calcaneusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
////    }
////
////
////    @Override
////    public Calcaneus saveCalcaneus(Calcaneus calcaneus) {
////        log.trace("saveCalcaneus() --- method entered");
////        try {
////            Calcaneus savedCalcaneus = calcaneusRepository.save(calcaneus);
////            log.trace("saveCalcaneus(): savedCalcaneus={}", savedCalcaneus);
////            return savedCalcaneus;
////        } catch (DataIntegrityViolationException e) {
////            log.error("Error while saving calcaneus: {}", e.getMessage());
////            throw new DataBaseOperationException("Error while saving calcaneus: " + e.getMessage());
////        }
////    }
////
////    @Transactional
////    @Override
////    public Calcaneus updateCalcaneus(Long id, Calcaneus calcaneus) {
////        log.trace("updateCalcaneus() --- method entered");
////        return calcaneusRepository.findById(id).map(existingCalcaneus -> {
////            existingCalcaneus.setMaxLength(calcaneus.getMaxLength());
////            existingCalcaneus.setMiddleBreadth(calcaneus.getMiddleBreadth());
////            return calcaneusRepository.save(existingCalcaneus);
////        }).orElseThrow(() -> new ResourceNotFoundException("Calcaneus with ID = " + id + " not found"));
////    }
////
////    @Override
////    public void deleteCalcaneusById(Long id) {
////        calcaneusRepository.delete(
////                calcaneusRepository.findById(id).orElseThrow(
////                        () -> new ResourceNotFoundException("Calcaneus with ID = " + id + " not found")
////                )
////        );
////    }
//}
