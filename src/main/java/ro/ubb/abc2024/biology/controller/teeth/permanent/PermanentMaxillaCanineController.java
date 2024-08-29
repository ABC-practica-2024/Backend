package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaCanine;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaCanineDto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaCanineMapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMaxillaCanineServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-maxilla-canine")
public class PermanentMaxillaCanineController
        extends GenericToothControllerImpl<PermanentMaxillaCanine, PermanentMaxillaCanineDto> {

    private final PermanentMaxillaCanineMapper mapper;

    public PermanentMaxillaCanineController(PermanentMaxillaCanineServiceImpl service,
                                            PermanentMaxillaCanineMapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMaxillaCanineDto convertToDto(PermanentMaxillaCanine entity) {
        return mapper.toDto(entity);
    }
}
