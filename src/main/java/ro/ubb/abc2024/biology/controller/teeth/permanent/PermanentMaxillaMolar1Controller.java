package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaMolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMaxillaMolar1ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-maxilla-molar1")
public class PermanentMaxillaMolar1Controller
        extends GenericToothControllerImpl<PermanentMaxillaMolar1, PermanentMaxillaMolar1Dto> {

    private final PermanentMaxillaMolar1Mapper mapper;

    public PermanentMaxillaMolar1Controller(PermanentMaxillaMolar1ServiceImpl service,
                                            PermanentMaxillaMolar1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMaxillaMolar1Dto convertToDto(PermanentMaxillaMolar1 entity) {
        return mapper.toDto(entity);
    }
}
