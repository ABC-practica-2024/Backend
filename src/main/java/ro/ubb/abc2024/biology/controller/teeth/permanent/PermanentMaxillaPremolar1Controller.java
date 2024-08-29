package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaPremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaPremolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaPremolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMaxillaPremolar1ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-maxilla-premolar1")
public class PermanentMaxillaPremolar1Controller
        extends GenericToothControllerImpl<PermanentMaxillaPremolar1, PermanentMaxillaPremolar1Dto> {

    private final PermanentMaxillaPremolar1Mapper mapper;

    public PermanentMaxillaPremolar1Controller(PermanentMaxillaPremolar1ServiceImpl service,
                                               PermanentMaxillaPremolar1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMaxillaPremolar1Dto convertToDto(PermanentMaxillaPremolar1 entity) {
        return mapper.toDto(entity);
    }
}
