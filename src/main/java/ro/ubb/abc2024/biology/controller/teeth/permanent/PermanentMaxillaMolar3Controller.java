package ro.ubb.abc2024.biology.controller.teeth.permanent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.controller.teeth.GenericToothControllerImpl;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar3;
import ro.ubb.abc2024.biology.dto.teeth.permanent.PermanentMaxillaMolar3Dto;
import ro.ubb.abc2024.biology.mapper.teeth.permanent.PermanentMaxillaMolar3Mapper;
import ro.ubb.abc2024.biology.service.teeth.permanent.PermanentMaxillaMolar3ServiceImpl;

@RestController
@RequestMapping("/api/v1/permanent-maxilla-molar3")
public class PermanentMaxillaMolar3Controller
        extends GenericToothControllerImpl<PermanentMaxillaMolar3, PermanentMaxillaMolar3Dto> {

    private final PermanentMaxillaMolar3Mapper mapper;

    public PermanentMaxillaMolar3Controller(PermanentMaxillaMolar3ServiceImpl service,
                                            PermanentMaxillaMolar3Mapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    protected PermanentMaxillaMolar3Dto convertToDto(PermanentMaxillaMolar3 entity) {
        return mapper.toDto(entity);
    }
}
