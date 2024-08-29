package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleMolar3Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleMolar3Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMandibleMolar3ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-mandible-molar3")
public class PermanentMandibleMolar3Controller
        extends GenericToothControllerImpl<PermanentMandibleMolar3, PermanentMandibleMolar3Dto> {

    private final PermanentMandibleMolar3Mapper mapper;

    public PermanentMandibleMolar3Controller(PermanentMandibleMolar3ServiceImpl service,
                                             PermanentMandibleMolar3Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMandibleMolar3Dto convertToDto(PermanentMandibleMolar3 entity) {
        return mapper.toDto(entity);
    }
}
