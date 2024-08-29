package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaCanineMapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMaxillaCanineServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-maxilla-canine")
public class DeciduousMaxillaCanineController
        extends GenericToothControllerImpl<DeciduousMaxillaCanine, DeciduousMaxillaCanineDto> {

    private final DeciduousMaxillaCanineMapper mapper;

    public DeciduousMaxillaCanineController(DeciduousMaxillaCanineServiceImpl service,
                                            DeciduousMaxillaCanineMapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMaxillaCanineDto convertToDto(DeciduousMaxillaCanine entity) {
        return mapper.toDto(entity);
    }
}
