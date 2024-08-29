package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleIncisor1Mapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMandibleIncisor1ServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-mandible-incisor1")
public class DeciduousMandibleIncisor1Controller
        extends GenericToothControllerImpl<DeciduousMandibleIncisor1, DeciduousMandibleIncisor1Dto> {

    private final DeciduousMandibleIncisor1Mapper mapper;

    public DeciduousMandibleIncisor1Controller(DeciduousMandibleIncisor1ServiceImpl service,
                                               DeciduousMandibleIncisor1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMandibleIncisor1Dto convertToDto(DeciduousMandibleIncisor1 entity) {
        return mapper.toDto(entity);
    }
}
