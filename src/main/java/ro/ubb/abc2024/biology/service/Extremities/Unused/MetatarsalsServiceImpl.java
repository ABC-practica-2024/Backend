//package ro.ubb.abc2024.biology.service.Extremities;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import ro.ubb.abc2024.biology.domain.Extremities.Metatarsals;
//import ro.ubb.abc2024.biology.domain.Extremities.Metatarsals;
//import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
//import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
//import ro.ubb.abc2024.biology.repository.Extremities.MetatarsalsRepository;
//import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IMetatarsalsService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MetatarsalsServiceImpl implements IMetatarsalsService {
//        private static final Logger log = LoggerFactory.getLogger(MetatarsalsServiceImpl.class);
//
//        @Autowired
//        private MetatarsalsRepository metatarsalsRepository;
//
//
//        @Override
//        public List<Metatarsals> getAllMetatarsals() {
//                log.trace("getAllMetatarsals() --- method entered");
//                List<Metatarsals> metatarsals = metatarsalsRepository.findAll();
//                return Optional.of(metatarsals)
//                        .filter(list -> !list.isEmpty())
//                        .orElseThrow(() -> new DataBaseOperationException("getAllMetatarsals() returned empty list"));
//        }
//
//        @Override
//        public Metatarsals getMetatarsalsById(Long id) {
//                log.trace("getMetatarsalsById() --- method entered");
//                return metatarsalsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found."));
//        }
//
//
//        @Override
//        public Metatarsals saveMetatarsals(Metatarsals metatarsals) {
//                log.trace("saveMetatarsals() --- method entered");
//                try {
//                        Metatarsals savedMetatarsals = metatarsalsRepository.save(metatarsals);
//                        log.trace("saveMetatarsals(): savedMetatarsals={}", savedMetatarsals);
//                        return savedMetatarsals;
//                } catch (DataIntegrityViolationException e) {
//                        log.error("Error while saving metatarsals: {}", e.getMessage());
//                        throw new DataBaseOperationException("Error while saving metatarsals: " + e.getMessage());
//                }
//        }
//
//        @Transactional
//        @Override
//        public Metatarsals updateMetatarsals(Long id, Metatarsals metatarsals) {
//                log.trace("updateMetatarsals() --- method entered");
//                return metatarsalsRepository.findById(id).map(existingMetatarsals -> {
//                        existingMetatarsals.setProximalJuvenileStageOfUnion(metatarsals.getProximalJuvenileStageOfUnion());
//                        existingMetatarsals.setDistalJuvenileStageOfUnion(metatarsals.getDistalJuvenileStageOfUnion());
//                        existingMetatarsals.setStagesOfDJD(metatarsals.getStagesOfDJD());
//                        return metatarsalsRepository.save(existingMetatarsals);
//                }).orElseThrow(() -> new ResourceNotFoundException("Metatarsals with ID = " + id + " not found"));
//        }
//
//        @Override
//        public void deleteMetatarsalsById(Long id) {
//                metatarsalsRepository.delete(
//                        metatarsalsRepository.findById(id).orElseThrow(
//                                () -> new ResourceNotFoundException("Metatarsals with ID = " + id + " not found")
//                        )
//                );
//        }
//}