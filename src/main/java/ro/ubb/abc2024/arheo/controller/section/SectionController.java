package ro.ubb.abc2024.arheo.controller.section;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.service.SectionService;
import ro.ubb.abc2024.arheo.utils.converter.SectionDtoConverter;
import ro.ubb.abc2024.arheo.utils.dto.SectionDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/sections")
public class SectionController {
    private final SectionService sectionService;
    private final SectionDtoConverter sectionDtoConverter;

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('ARH')")
    // get all sections
    public List<SectionDto> getSections() {
        return sectionService.getSections().stream()
                .map(sectionDtoConverter::createFromEntity)
                .collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAnyAuthority('ARH')")
    // add a new section, add it to the list of sections
    public SectionDto addSection(@RequestBody SectionDto sectionDto) {
        var section = sectionService.addSection(sectionDtoConverter.createFromDto(sectionDto));
        return sectionDtoConverter.createFromEntity(section);
    }
}
