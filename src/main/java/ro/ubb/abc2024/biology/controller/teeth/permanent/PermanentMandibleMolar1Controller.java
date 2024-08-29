package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMandibleMolar1ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-mandible-molar1")
public class PermanentMandibleMolar1Controller
        extends GenericToothControllerImpl<PermanentMandibleMolar1, PermanentMandibleMolar1Dto> {

    private final PermanentMandibleMolar1Mapper mapper;

    public PermanentMandibleMolar1Controller(PermanentMandibleMolar1ServiceImpl service,
                                             PermanentMandibleMolar1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMandibleMolar1Dto convertToDto(PermanentMandibleMolar1 entity) {
        return mapper.toDto(entity);
    }
}
