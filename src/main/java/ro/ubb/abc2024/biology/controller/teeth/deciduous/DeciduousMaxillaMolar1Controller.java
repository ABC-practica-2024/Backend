package ro.ubb.abc2024.biology.controller.teeth.deciduous;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.deciduous.DeciduousMaxillaMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.deciduous.DeciduousMaxillaMolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.deciduous.DeciduousMaxillaMolar1ServiceImpl;

@RestController
@RequestMapping("/api/v1/deciduous-maxilla-molar1")
public class DeciduousMaxillaMolar1Controller
        extends GenericToothControllerImpl<DeciduousMaxillaMolar1, DeciduousMaxillaMolar1Dto> {

    private final DeciduousMaxillaMolar1Mapper mapper;

    public DeciduousMaxillaMolar1Controller(DeciduousMaxillaMolar1ServiceImpl service,
                                            DeciduousMaxillaMolar1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected DeciduousMaxillaMolar1Dto convertToDto(DeciduousMaxillaMolar1 entity) {
        return mapper.toDto(entity);
    }
}
