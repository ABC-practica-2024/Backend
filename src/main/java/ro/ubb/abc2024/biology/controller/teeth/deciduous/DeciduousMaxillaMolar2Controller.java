package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaMolar2Mapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMaxillaMolar2ServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-maxilla-molar2")
public class DeciduousMaxillaMolar2Controller
        extends GenericToothControllerImpl<DeciduousMaxillaMolar2, DeciduousMaxillaMolar2Dto> {

    private final DeciduousMaxillaMolar2Mapper mapper;

    public DeciduousMaxillaMolar2Controller(DeciduousMaxillaMolar2ServiceImpl service,
                                            DeciduousMaxillaMolar2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMaxillaMolar2Dto convertToDto(DeciduousMaxillaMolar2 entity) {
        return mapper.toDto(entity);
    }
}
