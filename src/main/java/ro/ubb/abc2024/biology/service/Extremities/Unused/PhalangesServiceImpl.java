//package ro.ubb.abc2024.biology.service.Extremities;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremities.Phalanges;
//import ro.ubb.abc2024.biology.domain.Extremities.Phalanges;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.PhalangesRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IPhalangesService;
//
//import java.util.List;
//import java.util.Optional;
//@Service
//public class PhalangesServiceImpl implements IPhalangesService {
//    private static final Logger log = LoggerFactory.getLogger(PhalangesServiceImpl.class);
//
//    @Autowired
//    private PhalangesRepository phalangesRepository;
//
//
//    @Override
//    public List<Phalanges> getAllPhalanges() {
//        log.trace("getAllPhalanges() --- method entered");
//        List<Phalanges> phalanges = phalangesRepository.findAll();
//        return Optional.of(phalanges)
//                .filter(list -> !list.isEmpty())
//                .orElseThrow(() -> new DataBaseOperationException("getAllPhalanges() returned empty list"));
//    }
//
//    @Override
//    public Phalanges getPhalangesById(Long id) {
//        log.trace("getPhalangesById() --- method entered");
//        return phalangesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
//    }
//
//
//    @Override
//    public Phalanges savePhalanges(Phalanges phalanges) {
//        log.trace("savePhalanges() --- method entered");
//        try {
//            Phalanges savedPhalanges = phalangesRepository.save(phalanges);
//            log.trace("savePhalanges(): savedPhalanges={}", savedPhalanges);
//            return savedPhalanges;
//        } catch (DataIntegrityViolationException e) {
//            log.error("Error while saving phalanges: {}", e.getMessage());
//            throw new DataBaseOperationException("Error while saving phalanges: " + e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public Phalanges updatePhalanges(Long id, Phalanges phalanges) {
//        log.trace("updatePhalanges() --- method entered");
//        return phalangesRepository.findById(id).map(existingPhalanges -> {
//            existingPhalanges.setProximalJuvenile(phalanges.getProximalJuvenile());
//            existingPhalanges.setHandOrFoot(phalanges.getHandOrFoot());
//            existingPhalanges.setPosition(phalanges.getPosition());
//            return phalangesRepository.save(existingPhalanges);
//        }).orElseThrow(() -> new ResourceNotFoundException("Phalanges with ID = " + id + " not found"));
//    }
//
//    @Override
//    public void deletePhalangesById(Long id) {
//        phalangesRepository.delete(
//                phalangesRepository.findById(id).orElseThrow(
//                        () -> new ResourceNotFoundException("Phalanges with ID = " + id + " not found")
//                )
//        );
//    }
//}