package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandiblePremolar1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandiblePremolar1Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMandiblePremolar1ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-mandible-premolar1")
public class PermanentMandiblePremolar1Controller
        extends GenericToothControllerImpl<PermanentMandiblePremolar1, PermanentMandiblePremolar1Dto> {

    private final PermanentMandiblePremolar1Mapper mapper;

    public PermanentMandiblePremolar1Controller(PermanentMandiblePremolar1ServiceImpl service,
                                                PermanentMandiblePremolar1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMandiblePremolar1Dto convertToDto(PermanentMandiblePremolar1 entity) {
        return mapper.toDto(entity);
    }
}
