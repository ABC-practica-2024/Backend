package ro.ubb.abc2024.biology.service.teeth;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Tooth;
import ro.ubb.abc2024.biology.dto.ToothDto;
import ro.ubb.abc2024.biology.mapper.teeth.ToothMapper;
import ro.ubb.abc2024.biology.repository.teeth.deciduous.*;
import ro.ubb.abc2024.biology.repository.teeth.permanent.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ToothServiceImpl extends GenericServiceImpl<Tooth, ToothDto> implements SpecificToothService<Tooth, ToothDto> {

    private final PermanentMandibleCanineRepository permanentMandibleCanineRepository;
    private final PermanentMandibleIncisor1Repository permanentMandibleIncisor1Repository;
    private final PermanentMandibleIncisor2Repository permanentMandibleIncisor2Repository;
    private final PermanentMandibleMolar1Repository permanentMandibleMolar1Repository;
    private final PermanentMandibleMolar2Repository permanentMandibleMolar2Repository;
    private final PermanentMandibleMolar3Repository permanentMandibleMolar3Repository;
    private final PermanentMandiblePremolar1Repository permanentMandiblePremolar1Repository;
    private final PermanentMandiblePremolar2Repository permanentMandiblePremolar2Repository;
    private final PermanentMaxillaCanineRepository permanentMaxillaCanineRepository;
    private final PermanentMaxillaIncisor1Repository permanentMaxillaIncisor1Repository;
    private final PermanentMaxillaIncisor2Repository permanentMaxillaIncisor2Repository;
    private final PermanentMaxillaMolar1Repository permanentMaxillaMolar1Repository;
    private final PermanentMaxillaMolar2Repository permanentMaxillaMolar2Repository;
    private final PermanentMaxillaMolar3Repository permanentMaxillaMolar3Repository;
    private final PermanentMaxillaPremolar1Repository permanentMaxillaPremolar1Repository;
    private final PermanentMaxillaPremolar2Repository permanentMaxillaPremolar2Repository;

    private final DeciduousMandibleCanineRepository deciduousMandibleCanineRepository;
    private final DeciduousMandibleIncisor1Repository deciduousMandibleIncisor1Repository;
    private final DeciduousMandibleIncisor2Repository deciduousMandibleIncisor2Repository;
    private final DeciduousMandibleMolar1Repository deciduousMandibleMolar1Repository;
    private final DeciduousMandibleMolar2Repository deciduousMandibleMolar2Repository;
    private final DeciduousMaxillaCanineRepository deciduousMaxillaCanineRepository;
    private final DeciduousMaxillaIncisor1Repository deciduousMaxillaIncisor1Repository;
    private final DeciduousMaxillaIncisor2Repository deciduousMaxillaIncisor2Repository;
    private final DeciduousMaxillaMolar1Repository deciduousMaxillaMolar1Repository;
    private final DeciduousMaxillaMolar2Repository deciduousMaxillaMolar2Repository;

    private final ToothMapper mapper;

    @Autowired
    public ToothServiceImpl(
            PermanentMandibleCanineRepository permanentMandibleCanineRepository,
            PermanentMandibleIncisor1Repository permanentMandibleIncisor1Repository,
            PermanentMandibleIncisor2Repository permanentMandibleIncisor2Repository,
            PermanentMandibleMolar1Repository permanentMandibleMolar1Repository,
            PermanentMandibleMolar2Repository permanentMandibleMolar2Repository,
            PermanentMandibleMolar3Repository permanentMandibleMolar3Repository,
            PermanentMandiblePremolar1Repository permanentMandiblePremolar1Repository,
            PermanentMandiblePremolar2Repository permanentMandiblePremolar2Repository,
            PermanentMaxillaCanineRepository permanentMaxillaCanineRepository,
            PermanentMaxillaIncisor1Repository permanentMaxillaIncisor1Repository,
            PermanentMaxillaIncisor2Repository permanentMaxillaIncisor2Repository,
            PermanentMaxillaMolar1Repository permanentMaxillaMolar1Repository,
            PermanentMaxillaMolar2Repository permanentMaxillaMolar2Repository,
            PermanentMaxillaMolar3Repository permanentMaxillaMolar3Repository,
            PermanentMaxillaPremolar1Repository permanentMaxillaPremolar1Repository,
            PermanentMaxillaPremolar2Repository permanentMaxillaPremolar2Repository,

            DeciduousMandibleCanineRepository deciduousMandibleCanineRepository,
            DeciduousMandibleIncisor1Repository deciduousMandibleIncisor1Repository,
            DeciduousMandibleIncisor2Repository deciduousMandibleIncisor2Repository,
            DeciduousMandibleMolar1Repository deciduousMandibleMolar1Repository,
            DeciduousMandibleMolar2Repository deciduousMandibleMolar2Repository,
            DeciduousMaxillaCanineRepository deciduousMaxillaCanineRepository,
            DeciduousMaxillaIncisor1Repository deciduousMaxillaIncisor1Repository,
            DeciduousMaxillaIncisor2Repository deciduousMaxillaIncisor2Repository,
            DeciduousMaxillaMolar1Repository deciduousMaxillaMolar1Repository,
            DeciduousMaxillaMolar2Repository deciduousMaxillaMolar2Repository,

            ToothMapper mapper
    ) {
        super(null);
        this.permanentMandibleCanineRepository = permanentMandibleCanineRepository;
        this.permanentMandibleIncisor1Repository = permanentMandibleIncisor1Repository;
        this.permanentMandibleIncisor2Repository = permanentMandibleIncisor2Repository;
        this.permanentMandibleMolar1Repository = permanentMandibleMolar1Repository;
        this.permanentMandibleMolar2Repository = permanentMandibleMolar2Repository;
        this.permanentMandibleMolar3Repository = permanentMandibleMolar3Repository;
        this.permanentMandiblePremolar1Repository = permanentMandiblePremolar1Repository;
        this.permanentMandiblePremolar2Repository = permanentMandiblePremolar2Repository;
        this.permanentMaxillaCanineRepository = permanentMaxillaCanineRepository;
        this.permanentMaxillaIncisor1Repository = permanentMaxillaIncisor1Repository;
        this.permanentMaxillaIncisor2Repository = permanentMaxillaIncisor2Repository;
        this.permanentMaxillaMolar1Repository = permanentMaxillaMolar1Repository;
        this.permanentMaxillaMolar2Repository = permanentMaxillaMolar2Repository;
        this.permanentMaxillaMolar3Repository = permanentMaxillaMolar3Repository;
        this.permanentMaxillaPremolar1Repository = permanentMaxillaPremolar1Repository;
        this.permanentMaxillaPremolar2Repository = permanentMaxillaPremolar2Repository;

        this.deciduousMandibleCanineRepository = deciduousMandibleCanineRepository;
        this.deciduousMandibleIncisor1Repository = deciduousMandibleIncisor1Repository;
        this.deciduousMandibleIncisor2Repository = deciduousMandibleIncisor2Repository;
        this.deciduousMandibleMolar1Repository = deciduousMandibleMolar1Repository;
        this.deciduousMandibleMolar2Repository = deciduousMandibleMolar2Repository;
        this.deciduousMaxillaCanineRepository = deciduousMaxillaCanineRepository;
        this.deciduousMaxillaIncisor1Repository = deciduousMaxillaIncisor1Repository;
        this.deciduousMaxillaIncisor2Repository = deciduousMaxillaIncisor2Repository;
        this.deciduousMaxillaMolar1Repository = deciduousMaxillaMolar1Repository;
        this.deciduousMaxillaMolar2Repository = deciduousMaxillaMolar2Repository;

        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Tooth save(ToothDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public Tooth update(Long id, ToothDto dto) {
        Tooth existingEntity = getById(id);
        mapper.updateEntityFromDto(dto, existingEntity);
        return repository.save(existingEntity);
    }

    @Override
    public List<Tooth> getAllByArtefactId(UUID artefactId) {
        List<Tooth> teeth = new ArrayList<>();

        teeth.addAll(permanentMandibleCanineRepository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMandibleIncisor1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMandibleIncisor2Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMandibleMolar1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMandibleMolar2Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMandibleMolar3Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMandiblePremolar1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMandiblePremolar2Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMaxillaCanineRepository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMaxillaIncisor1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMaxillaIncisor2Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMaxillaMolar1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMaxillaMolar2Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMaxillaMolar3Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMaxillaPremolar1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(permanentMaxillaPremolar2Repository.getAllByArtefactId(artefactId));

        teeth.addAll(deciduousMandibleCanineRepository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMandibleIncisor1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMandibleIncisor2Repository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMandibleMolar1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMandibleMolar2Repository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMaxillaCanineRepository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMaxillaIncisor1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMaxillaIncisor2Repository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMaxillaMolar1Repository.getAllByArtefactId(artefactId));
        teeth.addAll(deciduousMaxillaMolar2Repository.getAllByArtefactId(artefactId));

        return teeth;
    }

}