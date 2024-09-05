package ro.ubb.abc2024.biology.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.domain.Tooth;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.*;
import ro.ubb.abc2024.biology.domain.teeth.permanent.*;
import ro.ubb.abc2024.biology.dto.ToothDto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.*;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.*;
import ro.ubb.abc2024.biology.service.teeth.ToothServiceImpl;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.endpoint.base-url}/teeth")
public class TeethController {

    private final ToothServiceImpl toothService;

    private final PermanentMandibleCanineMapper permanentMandibleCanineMapper;
    private final PermanentMandibleIncisor1Mapper permanentMandibleIncisor1Mapper;
    private final PermanentMandibleIncisor2Mapper permanentMandibleIncisor2Mapper;
    private final PermanentMandibleMolar1Mapper permanentMandibleMolar1Mapper;
    private final PermanentMandibleMolar2Mapper permanentMandibleMolar2Mapper;
    private final PermanentMandibleMolar3Mapper permanentMandibleMolar3Mapper;
    private final PermanentMandiblePremolar1Mapper permanentMandiblePremolar1Mapper;
    private final PermanentMandiblePremolar2Mapper permanentMandiblePremolar2Mapper;
    private final PermanentMaxillaCanineMapper permanentMaxillaCanineMapper;
    private final PermanentMaxillaIncisor1Mapper permanentMaxillaIncisor1Mapper;
    private final PermanentMaxillaIncisor2Mapper permanentMaxillaIncisor2Mapper;
    private final PermanentMaxillaMolar1Mapper permanentMaxillaMolar1Mapper;
    private final PermanentMaxillaMolar2Mapper permanentMaxillaMolar2Mapper;
    private final PermanentMaxillaMolar3Mapper permanentMaxillaMolar3Mapper;
    private final PermanentMaxillaPremolar1Mapper permanentMaxillaPremolar1Mapper;
    private final PermanentMaxillaPremolar2Mapper permanentMaxillaPremolar2Mapper;
    private final DeciduousMandibleCanineMapper deciduousMandibleCanineMapper;
    private final DeciduousMandibleIncisor1Mapper deciduousMandibleIncisor1Mapper;
    private final DeciduousMandibleIncisor2Mapper deciduousMandibleIncisor2Mapper;
    private final DeciduousMandibleMolar1Mapper deciduousMandibleMolar1Mapper;
    private final DeciduousMandibleMolar2Mapper deciduousMandibleMolar2Mapper;
    private final DeciduousMaxillaCanineMapper deciduousMaxillaCanineMapper;
    private final DeciduousMaxillaIncisor1Mapper deciduousMaxillaIncisor1Mapper;
    private final DeciduousMaxillaIncisor2Mapper deciduousMaxillaIncisor2Mapper;
    private final DeciduousMaxillaMolar1Mapper deciduousMaxillaMolar1Mapper;
    private final DeciduousMaxillaMolar2Mapper deciduousMaxillaMolar2Mapper;

    @Autowired
    public TeethController(
            ToothServiceImpl toothService,
            PermanentMandibleCanineMapper permanentMandibleCanineMapper,
            PermanentMandibleIncisor1Mapper permanentMandibleIncisor1Mapper,
            PermanentMandibleIncisor2Mapper permanentMandibleIncisor2Mapper,
            PermanentMandibleMolar1Mapper permanentMandibleMolar1Mapper,
            PermanentMandibleMolar2Mapper permanentMandibleMolar2Mapper,
            PermanentMandibleMolar3Mapper permanentMandibleMolar3Mapper,
            PermanentMandiblePremolar1Mapper permanentMandiblePremolar1Mapper,
            PermanentMandiblePremolar2Mapper permanentMandiblePremolar2Mapper,
            PermanentMaxillaCanineMapper permanentMaxillaCanineMapper,
            PermanentMaxillaIncisor1Mapper permanentMaxillaIncisor1Mapper,
            PermanentMaxillaIncisor2Mapper permanentMaxillaIncisor2Mapper,
            PermanentMaxillaMolar1Mapper permanentMaxillaMolar1Mapper,
            PermanentMaxillaMolar2Mapper permanentMaxillaMolar2Mapper,
            PermanentMaxillaMolar3Mapper permanentMaxillaMolar3Mapper,
            PermanentMaxillaPremolar1Mapper permanentMaxillaPremolar1Mapper,
            PermanentMaxillaPremolar2Mapper permanentMaxillaPremolar2Mapper,
            DeciduousMandibleCanineMapper deciduousMandibleCanineMapper,
            DeciduousMandibleIncisor1Mapper deciduousMandibleIncisor1Mapper,
            DeciduousMandibleIncisor2Mapper deciduousMandibleIncisor2Mapper,
            DeciduousMandibleMolar1Mapper deciduousMandibleMolar1Mapper,
            DeciduousMandibleMolar2Mapper deciduousMandibleMolar2Mapper,
            DeciduousMaxillaCanineMapper deciduousMaxillaCanineMapper,
            DeciduousMaxillaIncisor1Mapper deciduousMaxillaIncisor1Mapper,
            DeciduousMaxillaIncisor2Mapper deciduousMaxillaIncisor2Mapper,
            DeciduousMaxillaMolar1Mapper deciduousMaxillaMolar1Mapper,
            DeciduousMaxillaMolar2Mapper deciduousMaxillaMolar2Mapper
    ) {
        this.toothService = toothService;
        this.permanentMandibleCanineMapper = permanentMandibleCanineMapper;
        this.permanentMandibleIncisor1Mapper = permanentMandibleIncisor1Mapper;
        this.permanentMandibleIncisor2Mapper = permanentMandibleIncisor2Mapper;
        this.permanentMandibleMolar1Mapper = permanentMandibleMolar1Mapper;
        this.permanentMandibleMolar2Mapper = permanentMandibleMolar2Mapper;
        this.permanentMandibleMolar3Mapper = permanentMandibleMolar3Mapper;
        this.permanentMandiblePremolar1Mapper = permanentMandiblePremolar1Mapper;
        this.permanentMandiblePremolar2Mapper = permanentMandiblePremolar2Mapper;
        this.permanentMaxillaCanineMapper = permanentMaxillaCanineMapper;
        this.permanentMaxillaIncisor1Mapper = permanentMaxillaIncisor1Mapper;
        this.permanentMaxillaIncisor2Mapper = permanentMaxillaIncisor2Mapper;
        this.permanentMaxillaMolar1Mapper = permanentMaxillaMolar1Mapper;
        this.permanentMaxillaMolar2Mapper = permanentMaxillaMolar2Mapper;
        this.permanentMaxillaMolar3Mapper = permanentMaxillaMolar3Mapper;
        this.permanentMaxillaPremolar1Mapper = permanentMaxillaPremolar1Mapper;
        this.permanentMaxillaPremolar2Mapper = permanentMaxillaPremolar2Mapper;
        this.deciduousMandibleCanineMapper = deciduousMandibleCanineMapper;
        this.deciduousMandibleIncisor1Mapper = deciduousMandibleIncisor1Mapper;
        this.deciduousMandibleIncisor2Mapper = deciduousMandibleIncisor2Mapper;
        this.deciduousMandibleMolar1Mapper = deciduousMandibleMolar1Mapper;
        this.deciduousMandibleMolar2Mapper = deciduousMandibleMolar2Mapper;
        this.deciduousMaxillaCanineMapper = deciduousMaxillaCanineMapper;
        this.deciduousMaxillaIncisor1Mapper = deciduousMaxillaIncisor1Mapper;
        this.deciduousMaxillaIncisor2Mapper = deciduousMaxillaIncisor2Mapper;
        this.deciduousMaxillaMolar1Mapper = deciduousMaxillaMolar1Mapper;
        this.deciduousMaxillaMolar2Mapper = deciduousMaxillaMolar2Mapper;
    }

    @GetMapping("/{artefactId}")
    public Result<List<ToothDto>> getAllTeethByArtefactId(@PathVariable UUID artefactId) {
        List<Tooth> entities = toothService.getAllByArtefactId(artefactId);
        if (entities.isEmpty()) {
            throw new EntityNotFoundException("Entities not found");
        }
        List<ToothDto> dtos = entities.stream().map(this::mapToDto).toList();
        return new Result<>(true, HttpStatus.OK.value(), "Entities retrieved successfully", dtos);
    }

    private ToothDto mapToDto(Tooth tooth) {
        return switch (tooth.getToothType()) {
            case PERMANENT_MANDIBLE_CANINE -> permanentMandibleCanineMapper.toDto((PermanentMandibleCanine) tooth);
            case PERMANENT_MANDIBLE_INCISOR1 -> permanentMandibleIncisor1Mapper.toDto((PermanentMandibleIncisor1) tooth);
            case PERMANENT_MANDIBLE_INCISOR2 -> permanentMandibleIncisor2Mapper.toDto((PermanentMandibleIncisor2) tooth);
            case PERMANENT_MANDIBLE_MOLAR1 -> permanentMandibleMolar1Mapper.toDto((PermanentMandibleMolar1) tooth);
            case PERMANENT_MANDIBLE_MOLAR2 -> permanentMandibleMolar2Mapper.toDto((PermanentMandibleMolar2) tooth);
            case PERMANENT_MANDIBLE_MOLAR3 -> permanentMandibleMolar3Mapper.toDto((PermanentMandibleMolar3) tooth);
            case PERMANENT_MANDIBLE_PREMOLAR1 -> permanentMandiblePremolar1Mapper.toDto((PermanentMandiblePremolar1) tooth);
            case PERMANENT_MANDIBLE_PREMOLAR2 -> permanentMandiblePremolar2Mapper.toDto((PermanentMandiblePremolar2) tooth);
            case PERMANENT_MAXILLA_CANINE -> permanentMaxillaCanineMapper.toDto((PermanentMaxillaCanine) tooth);
            case PERMANENT_MAXILLA_INCISOR1 -> permanentMaxillaIncisor1Mapper.toDto((PermanentMaxillaIncisor1) tooth);
            case PERMANENT_MAXILLA_INCISOR2 -> permanentMaxillaIncisor2Mapper.toDto((PermanentMaxillaIncisor2) tooth);
            case PERMANENT_MAXILLA_MOLAR1 -> permanentMaxillaMolar1Mapper.toDto((PermanentMaxillaMolar1) tooth);
            case PERMANENT_MAXILLA_MOLAR2 -> permanentMaxillaMolar2Mapper.toDto((PermanentMaxillaMolar2) tooth);
            case PERMANENT_MAXILLA_MOLAR3 -> permanentMaxillaMolar3Mapper.toDto((PermanentMaxillaMolar3) tooth);
            case PERMANENT_MAXILLA_PREMOLAR1 -> permanentMaxillaPremolar1Mapper.toDto((PermanentMaxillaPremolar1) tooth);
            case PERMANENT_MAXILLA_PREMOLAR2 -> permanentMaxillaPremolar2Mapper.toDto((PermanentMaxillaPremolar2) tooth);
            case DECIDUOUS_MANDIBLE_CANINE -> deciduousMandibleCanineMapper.toDto((DeciduousMandibleCanine) tooth);
            case DECIDUOUS_MANDIBLE_INCISOR1 -> deciduousMandibleIncisor1Mapper.toDto((DeciduousMandibleIncisor1) tooth);
            case DECIDUOUS_MANDIBLE_INCISOR2 -> deciduousMandibleIncisor2Mapper.toDto((DeciduousMandibleIncisor2) tooth);
            case DECIDUOUS_MANDIBLE_MOLAR1 -> deciduousMandibleMolar1Mapper.toDto((DeciduousMandibleMolar1) tooth);
            case DECIDUOUS_MANDIBLE_MOLAR2 -> deciduousMandibleMolar2Mapper.toDto((DeciduousMandibleMolar2) tooth);
            case DECIDUOUS_MAXILLA_CANINE -> deciduousMaxillaCanineMapper.toDto((DeciduousMaxillaCanine) tooth);
            case DECIDUOUS_MAXILLA_INCISOR1 -> deciduousMaxillaIncisor1Mapper.toDto((DeciduousMaxillaIncisor1) tooth);
            case DECIDUOUS_MAXILLA_INCISOR2 -> deciduousMaxillaIncisor2Mapper.toDto((DeciduousMaxillaIncisor2) tooth);
            case DECIDUOUS_MAXILLA_MOLAR1 -> deciduousMaxillaMolar1Mapper.toDto((DeciduousMaxillaMolar1) tooth);
            case DECIDUOUS_MAXILLA_MOLAR2 -> deciduousMaxillaMolar2Mapper.toDto((DeciduousMaxillaMolar2) tooth);
        };
    }

}

