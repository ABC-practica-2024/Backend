package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaPremolar2Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMaxillaPremolar2ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-maxilla-premolar2")
public class PermanentMaxillaPremolar2Controller
        extends GenericToothControllerImpl<PermanentMaxillaPremolar2, PermanentMaxillaPremolar2Dto> {

    private final PermanentMaxillaPremolar2Mapper mapper;

    public PermanentMaxillaPremolar2Controller(PermanentMaxillaPremolar2ServiceImpl service,
                                               PermanentMaxillaPremolar2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMaxillaPremolar2Dto convertToDto(PermanentMaxillaPremolar2 entity) {
        return mapper.toDto(entity);
    }
}
