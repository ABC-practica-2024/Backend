package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleCanineMapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMandibleCanineServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-mandible-canine")
public class DeciduousMandibleCanineController
        extends GenericToothControllerImpl<DeciduousMandibleCanine, DeciduousMandibleCanineDto> {

    private final DeciduousMandibleCanineMapper mapper;

    public DeciduousMandibleCanineController(DeciduousMandibleCanineServiceImpl service,
                                             DeciduousMandibleCanineMapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMandibleCanineDto convertToDto(DeciduousMandibleCanine entity) {
        return mapper.toDto(entity);
    }
}
