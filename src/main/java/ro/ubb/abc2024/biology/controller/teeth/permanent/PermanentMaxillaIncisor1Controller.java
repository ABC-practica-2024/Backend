package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor1;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor1Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaIncisor1Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMaxillaIncisor1ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-maxilla-incisor1")
public class PermanentMaxillaIncisor1Controller
        extends GenericToothControllerImpl<PermanentMaxillaIncisor1, PermanentMaxillaIncisor1Dto> {

    private final PermanentMaxillaIncisor1Mapper mapper;

    public PermanentMaxillaIncisor1Controller(PermanentMaxillaIncisor1ServiceImpl service,
                                              PermanentMaxillaIncisor1Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMaxillaIncisor1Dto convertToDto(PermanentMaxillaIncisor1 entity) {
        return mapper.toDto(entity);
    }
}
