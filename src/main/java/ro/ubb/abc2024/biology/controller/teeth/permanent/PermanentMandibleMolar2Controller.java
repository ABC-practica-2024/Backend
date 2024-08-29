package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar2Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMandibleMolar2ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-mandible-molar2")
public class PermanentMandibleMolar2Controller
        extends GenericToothControllerImpl<PermanentMandibleMolar2, PermanentMandibleMolar2Dto> {

    private final PermanentMandibleMolar2Mapper mapper;

    public PermanentMandibleMolar2Controller(PermanentMandibleMolar2ServiceImpl service,
                                             PermanentMandibleMolar2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMandibleMolar2Dto convertToDto(PermanentMandibleMolar2 entity) {
        return mapper.toDto(entity);
    }
}
