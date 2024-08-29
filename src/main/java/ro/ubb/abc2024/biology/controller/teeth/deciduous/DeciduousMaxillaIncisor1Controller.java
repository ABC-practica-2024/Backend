package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaIncisor1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaIncisor1Mapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMaxillaIncisor1ServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-maxilla-incisor1")
public class DeciduousMaxillaIncisor1Controller
        extends GenericToothControllerImpl<DeciduousMaxillaIncisor1, DeciduousMaxillaIncisor1Dto> {

    private final DeciduousMaxillaIncisor1Mapper mapper;

    public DeciduousMaxillaIncisor1Controller(DeciduousMaxillaIncisor1ServiceImpl service,
                                              DeciduousMaxillaIncisor1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMaxillaIncisor1Dto convertToDto(DeciduousMaxillaIncisor1 entity) {
        return mapper.toDto(entity);
    }
}
