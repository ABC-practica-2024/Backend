package ro.ubb.abc2024.biology.service.Extremities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.Extremities;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.ubb.abc2024.biology.exception.DataBaseOperationException;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.ExtremitiesRepository;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IExtremitiesService;

@Service
public class ExtremitiesServiceImpl implements IExtremitiesService {
    private static final Logger log = LoggerFactory.getLogger(ExtremitiesServiceImpl.class);

    @Autowired
    private ExtremitiesRepository extremitiesRepository;


    @Override
    public List<Extremities> getAllExtremities() {
        log.trace("getAllExtremities() --- method entered");
        List<Extremities> extremities = extremitiesRepository.findAll();
        if (extremities.isEmpty()) {
            log.error("getAllExtremities() returned empty list");
            throw new DataBaseOperationException("getAllExtremities() returned empty list");
        } else {
            log.trace("getAllExtremities(): extremities.size={}", extremities.size());
            return extremities;
        }
    }

    @Override
    public Extremities getExtremitiesById(Long id) {
        log.trace("getExtremitiesById() --- method entered");
        Optional<Extremities> extremitiesOptional = extremitiesRepository.findById(id);
        if (extremitiesOptional.isPresent()) {
            Extremities extremities = extremitiesOptional.get();
            return extremities;
        } else {
            log.error("getExtremitiesById(): extremities={} not found", id);
            throw new ResourceNotFoundException("getExtremitiesById(): extremities={} not found");
        }
    }

    @Override
    public Extremities saveExtremities(Extremities extremities) {
        log.trace("saveExtremities() --- method entered");
        try {
            Extremities savedExtremities = extremitiesRepository.save(extremities);
            log.trace("saveExtremities(): savedExtremities={}", savedExtremities);
            return savedExtremities;
        } catch (DataIntegrityViolationException e) {
            log.error("Error while saving extremities: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving extremities: " + e.getMessage());
        }
    }

    @Override
    public Extremities updateExtremities(Long id, Extremities extremities) {
        log.trace("updateExtremities() --- method entered");
        Optional<Extremities> optionalExtremities = extremitiesRepository.findById(id);
        if (optionalExtremities.isPresent()) {
            Extremities updatedExtremities = optionalExtremities.get();
            updatedExtremities.setBonesNo(extremities.getBonesNo());
            updatedExtremities.setInventoryCondition(extremities.getInventoryCondition());
            updatedExtremities.setBoneType(extremities.getBoneType());

            log.trace("updateExtremities(): updatedExtremities={}", updatedExtremities);
            return extremitiesRepository.save(updatedExtremities);
        } else {
            log.error("updateExtremities(): extremities={} not found", extremities);
            throw new ResourceNotFoundException("Extremities with ID = " + id + " not found");
        }
    }

    @Override
    public void deleteExtremitiesById(Long id) {
        log.trace("deleteExtremitiesById() --- method entered");
        Optional<Extremities> optionalExtremities = extremitiesRepository.findById(id);
        if (optionalExtremities.isPresent()) {
            extremitiesRepository.delete(optionalExtremities.get());
            log.trace("deleteExtremitiesById(): extremities={}", optionalExtremities.get());
        } else {
            log.error("deleteExtremitiesById(): extremities={} not found", id);
            throw new ResourceNotFoundException("deleteExtremitiesById(): extremities={} not found");
        }
    }
}
