package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaIncisor2Mapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMaxillaIncisor2ServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-maxilla-incisor2")
public class DeciduousMaxillaIncisor2Controller
        extends GenericToothControllerImpl<DeciduousMaxillaIncisor2, DeciduousMaxillaIncisor2Dto> {

    private final DeciduousMaxillaIncisor2Mapper mapper;

    public DeciduousMaxillaIncisor2Controller(DeciduousMaxillaIncisor2ServiceImpl service,
                                              DeciduousMaxillaIncisor2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMaxillaIncisor2Dto convertToDto(DeciduousMaxillaIncisor2 entity) {
        return mapper.toDto(entity);
    }
}
