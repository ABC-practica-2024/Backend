package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor2;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaIncisor2Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaIncisor2Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMaxillaIncisor2ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-maxilla-incisor2")
public class PermanentMaxillaIncisor2Controller
        extends GenericToothControllerImpl<PermanentMaxillaIncisor2, PermanentMaxillaIncisor2Dto> {

    private final PermanentMaxillaIncisor2Mapper mapper;

    public PermanentMaxillaIncisor2Controller(PermanentMaxillaIncisor2ServiceImpl service,
                                              PermanentMaxillaIncisor2Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMaxillaIncisor2Dto convertToDto(PermanentMaxillaIncisor2 entity) {
        return mapper.toDto(entity);
    }
}
