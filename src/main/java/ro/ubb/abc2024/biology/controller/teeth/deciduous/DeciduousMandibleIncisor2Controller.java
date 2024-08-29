package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMandibleIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMandibleIncisor2Mapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMandibleIncisor2ServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-mandible-incisor2")
public class DeciduousMandibleIncisor2Controller
        extends GenericToothControllerImpl<DeciduousMandibleIncisor2, DeciduousMandibleIncisor2Dto> {

    private final DeciduousMandibleIncisor2Mapper mapper;

    public DeciduousMandibleIncisor2Controller(DeciduousMandibleIncisor2ServiceImpl service,
                                               DeciduousMandibleIncisor2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMandibleIncisor2Dto convertToDto(DeciduousMandibleIncisor2 entity) {
        return mapper.toDto(entity);
    }
}
