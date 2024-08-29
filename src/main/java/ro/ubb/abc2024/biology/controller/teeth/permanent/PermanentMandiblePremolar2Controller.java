package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandiblePremolar2Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMandiblePremolar2ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-mandible-premolar2")
public class PermanentMandiblePremolar2Controller
        extends GenericToothControllerImpl<PermanentMandiblePremolar2, PermanentMandiblePremolar2Dto> {

    private final PermanentMandiblePremolar2Mapper mapper;

    public PermanentMandiblePremolar2Controller(PermanentMandiblePremolar2ServiceImpl service,
                                                PermanentMandiblePremolar2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMandiblePremolar2Dto convertToDto(PermanentMandiblePremolar2 entity) {
        return mapper.toDto(entity);
    }
}
