package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleMolar2Mapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMandibleMolar2ServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-mandible-molar2")
public class DeciduousMandibleMolar2Controller
        extends GenericToothControllerImpl<DeciduousMandibleMolar2, DeciduousMandibleMolar2Dto> {

    private final DeciduousMandibleMolar2Mapper mapper;

    public DeciduousMandibleMolar2Controller(DeciduousMandibleMolar2ServiceImpl service,
                                             DeciduousMandibleMolar2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMandibleMolar2Dto convertToDto(DeciduousMandibleMolar2 entity) {
        return mapper.toDto(entity);
    }
}
