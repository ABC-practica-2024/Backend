package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMandibleIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMandibleIncisor2Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMandibleIncisor2ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-mandible-incisor2")
public class PermanentMandibleIncisor2Controller
        extends GenericToothControllerImpl<PermanentMandibleIncisor2, PermanentMandibleIncisor2Dto> {

    private final PermanentMandibleIncisor2Mapper mapper;

    public PermanentMandibleIncisor2Controller(PermanentMandibleIncisor2ServiceImpl service,
                                               PermanentMandibleIncisor2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMandibleIncisor2Dto convertToDto(PermanentMandibleIncisor2 entity) {
        return mapper.toDto(entity);
    }
}
