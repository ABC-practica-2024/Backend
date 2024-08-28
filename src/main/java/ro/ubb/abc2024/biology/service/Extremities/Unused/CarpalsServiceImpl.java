//package ro.ubb.abc2024.biology.service.Extremities;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
//import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.CarpalsRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICarpalsService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CarpalsServiceImpl implements ICarpalsService {
//    private static final Logger log = LoggerFactory.getLogger(CarpalsServiceImpl.class);
//
//    @Autowired
//    private CarpalsRepository carpalsRepository;
//
//
//    @Override
//    public List<Carpals> getAllCarpals() {
//        log.trace("getAllCarpals() --- method entered");
//        List<Carpals> carpals = carpalsRepository.findAll();
//        return Optional.of(carpals)
//                .filter(list -> !list.isEmpty())
//                .orElseThrow(() -> new DataBaseOperationException("getAllCarpals() returned empty list"));
//    }
//
//    @Override
//    public Carpals getCarpalsById(Long id) {
//        log.trace("getCarpalsById() --- method entered");
//        return carpalsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
//    }
//
//
//    @Override
//    public Carpals saveCarpals(Carpals carpals) {
//        log.trace("saveCarpals() --- method entered");
//        try {
//            Carpals savedCarpals = carpalsRepository.save(carpals);
//            log.trace("saveCarpals(): savedCarpals={}", savedCarpals);
//            return savedCarpals;
//        } catch (DataIntegrityViolationException e) {
//            log.error("Error while saving carpals: {}", e.getMessage());
//            throw new DataBaseOperationException("Error while saving carpals: " + e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public Carpals updateCarpals(Long id, Carpals carpals) {
//        log.trace("updateCarpals() --- method entered");
//        return carpalsRepository.findById(id).map(existingCarpals -> {
//            existingCarpals.setStagesOfDJD(carpals.getStagesOfDJD());
//            return carpalsRepository.save(existingCarpals);
//        }).orElseThrow(() -> new ResourceNotFoundException("Carpals with ID = " + id + " not found"));
//    }
//
//    @Override
//    public void deleteCarpalsById(Long id) {
//        carpalsRepository.delete(
//                carpalsRepository.findById(id).orElseThrow(
//                        () -> new ResourceNotFoundException("Carpals with ID = " + id + " not found")
//                )
//        );
//    }
//}