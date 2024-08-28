//package ro.ubb.abc2024.biology.service.Extremities;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremities.OtherTarsals;
//import ro.ubb.abc2024.biology.domain.Extremities.OtherTarsals;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.OtherTarsalsRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IOtherTarsalsService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class OtherTarsalsServiceImpl implements IOtherTarsalsService {
//    private static final Logger log = LoggerFactory.getLogger(OtherTarsalsServiceImpl.class);
//
//    @Autowired
//    private OtherTarsalsRepository otherTarsalsRepository;
//
//
//    @Override
//    public List<OtherTarsals> getAllOtherTarsals() {
//        log.trace("getAllOtherTarsals() --- method entered");
//        List<OtherTarsals> otherTarsals = otherTarsalsRepository.findAll();
//        return Optional.of(otherTarsals)
//                .filter(list -> !list.isEmpty())
//                .orElseThrow(() -> new DataBaseOperationException("getAllOtherTarsals() returned empty list"));
//    }
//
//    @Override
//    public OtherTarsals getOtherTarsalsById(Long id) {
//        log.trace("getOtherTarsalsById() --- method entered");
//        return otherTarsalsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
//    }
//
//
//    @Override
//    public OtherTarsals saveOtherTarsals(OtherTarsals otherTarsals) {
//        log.trace("saveOtherTarsals() --- method entered");
//        try {
//            OtherTarsals savedOtherTarsals = otherTarsalsRepository.save(otherTarsals);
//            log.trace("saveOtherTarsals(): savedOtherTarsals={}", savedOtherTarsals);
//            return savedOtherTarsals;
//        } catch (DataIntegrityViolationException e) {
//            log.error("Error while saving otherTarsals: {}", e.getMessage());
//            throw new DataBaseOperationException("Error while saving otherTarsals: " + e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public OtherTarsals updateOtherTarsals(Long id, OtherTarsals otherTarsals) {
//        log.trace("updateOtherTarsals() --- method entered");
//        return otherTarsalsRepository.findById(id).map(existingOtherTarsals -> {
//            existingOtherTarsals.setStagesOfDJD(otherTarsals.getStagesOfDJD());
//            return otherTarsalsRepository.save(existingOtherTarsals);
//        }).orElseThrow(() -> new ResourceNotFoundException("OtherTarsals with ID = " + id + " not found"));
//    }
//
//    @Override
//    public void deleteOtherTarsalsById(Long id) {
//        otherTarsalsRepository.delete(
//                otherTarsalsRepository.findById(id).orElseThrow(
//                        () -> new ResourceNotFoundException("OtherTarsals with ID = " + id + " not found")
//                )
//        );
//    }
//}