package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleCanineMapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMandibleCanineServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-mandible-canine")
public class PermanentMandibleCanineController
        extends GenericToothControllerImpl<PermanentMandibleCanine, PermanentMandibleCanineDto> {

    private final PermanentMandibleCanineMapper mapper;

    public PermanentMandibleCanineController(PermanentMandibleCanineServiceImpl service,
                                             PermanentMandibleCanineMapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMandibleCanineDto convertToDto(PermanentMandibleCanine entity) {
        return mapper.toDto(entity);
    }
}
