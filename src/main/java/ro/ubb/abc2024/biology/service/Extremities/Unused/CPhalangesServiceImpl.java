//package ro.ubb.abc2024.biology.service.Extremities;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremities.CPhalanges;
//import ro.ubb.abc2024.biology.domain.Extremities.CPhalanges;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.CPhalangesRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICPhalangesService;
//
//import java.util.List;
//import java.util.Optional;
//@Service
//public class CPhalangesServiceImpl implements ICPhalangesService {
//    private static final Logger log = LoggerFactory.getLogger(CPhalangesServiceImpl.class);
//
//    @Autowired
//    private CPhalangesRepository cPhalangesRepository;
//
//
//    @Override
//    public List<CPhalanges> getAllCPhalanges() {
//        log.trace("getAllCPhalanges() --- method entered");
//        List<CPhalanges> cPhalanges = cPhalangesRepository.findAll();
//        return Optional.of(cPhalanges)
//                .filter(list -> !list.isEmpty())
//                .orElseThrow(() -> new DataBaseOperationException("getAllCPhalanges() returned empty list"));
//    }
//
//    @Override
//    public CPhalanges getCPhalangesById(Long id) {
//        log.trace("getCPhalangesById() --- method entered");
//        return cPhalangesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
//    }
//
//
//    @Override
//    public CPhalanges saveCPhalanges(CPhalanges cPhalanges) {
//        log.trace("saveCPhalanges() --- method entered");
//        try {
//            CPhalanges savedCPhalanges = cPhalangesRepository.save(cPhalanges);
//            log.trace("saveCPhalanges(): savedCPhalanges={}", savedCPhalanges);
//            return savedCPhalanges;
//        } catch (DataIntegrityViolationException e) {
//            log.error("Error while saving cPhalanges: {}", e.getMessage());
//            throw new DataBaseOperationException("Error while saving cPhalanges: " + e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public CPhalanges updateCPhalanges(Long id, CPhalanges cPhalanges) {
//        log.trace("updateCPhalanges() --- method entered");
//        return cPhalangesRepository.findById(id).map(existingCPhalanges -> {
//            existingCPhalanges.setProximalJuvenileStageOfUnion(cPhalanges.getProximalJuvenileStageOfUnion());
//            existingCPhalanges.setPosition(cPhalanges.getPosition());
//            existingCPhalanges.setStagesOfDJD(cPhalanges.getStagesOfDJD());
//            return cPhalangesRepository.save(existingCPhalanges);
//        }).orElseThrow(() -> new ResourceNotFoundException("CPhalanges with ID = " + id + " not found"));
//    }
//
//    @Override
//    public void deleteCPhalangesById(Long id) {
//        cPhalangesRepository.delete(
//                cPhalangesRepository.findById(id).orElseThrow(
//                        () -> new ResourceNotFoundException("CPhalanges with ID = " + id + " not found")
//                )
//        );
//    }
//}