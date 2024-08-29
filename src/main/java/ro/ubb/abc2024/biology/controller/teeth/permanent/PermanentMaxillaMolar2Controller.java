package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaMolar2Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMaxillaMolar2ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-maxilla-molar2")
public class PermanentMaxillaMolar2Controller
        extends GenericToothControllerImpl<PermanentMaxillaMolar2, PermanentMaxillaMolar2Dto> {

    private final PermanentMaxillaMolar2Mapper mapper;

    public PermanentMaxillaMolar2Controller(PermanentMaxillaMolar2ServiceImpl service,
                                            PermanentMaxillaMolar2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMaxillaMolar2Dto convertToDto(PermanentMaxillaMolar2 entity) {
        return mapper.toDto(entity);
    }
}
