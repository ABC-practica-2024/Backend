package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleIncisor1Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMandibleIncisor1ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-mandible-incisor1")
public class PermanentMandibleIncisor1Controller
        extends GenericToothControllerImpl<PermanentMandibleIncisor1, PermanentMandibleIncisor1Dto> {

    private final PermanentMandibleIncisor1Mapper mapper;

    public PermanentMandibleIncisor1Controller(PermanentMandibleIncisor1ServiceImpl service,
                                               PermanentMandibleIncisor1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMandibleIncisor1Dto convertToDto(PermanentMandibleIncisor1 entity) {
        return mapper.toDto(entity);
    }
}
