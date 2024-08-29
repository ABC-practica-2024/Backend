package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleMolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMandibleMolar1ServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-mandible-molar1")
public class DeciduousMandibleMolar1Controller
        extends GenericToothControllerImpl<DeciduousMandibleMolar1, DeciduousMandibleMolar1Dto> {

    private final DeciduousMandibleMolar1Mapper mapper;

    public DeciduousMandibleMolar1Controller(DeciduousMandibleMolar1ServiceImpl service,
                                            DeciduousMandibleMolar1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMandibleMolar1Dto convertToDto(DeciduousMandibleMolar1 entity) {
        return mapper.toDto(entity);
    }
}
