package ro.ubb.abc2024.arheo.controller.section;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.service.SectionService;
import ro.ubb.abc2024.arheo.utils.converter.SectionDtoConverter;
import ro.ubb.abc2024.arheo.utils.dto.SectionDto;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.utils.dto.Result;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/sections")
@SecurityRequirement(name = "bearerAuth")
public class SectionController {
    private final SectionService sectionService;
    private final SectionDtoConverter sectionDtoConverter;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    // get all sections
    public Result<List<SectionDto>> getSections() {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all sections", sectionService.getSections().stream()
                .map(sectionDtoConverter::createFromEntity)
                .collect(Collectors.toList()));
    }

    // get by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    public Result<SectionDto> getSection(@PathVariable long id) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved section", sectionDtoConverter.createFromEntity(sectionService.getSection(id)));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    // add a new section, add it to the list of sections
    public Result<SectionDto> addSection(@RequestBody SectionDto sectionDto) {
        var section = sectionService.addSection(sectionDtoConverter.createFromDto(sectionDto));
        //return sectionDtoConverter.createFromEntity(section);
        return new Result<>(true, HttpStatus.CREATED.value(), "Added section", sectionDtoConverter.createFromEntity(section));
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    public Result<SectionDto> removeSection(@RequestBody long sectionId){
        // given a section id, remove the section from the list of sections
        sectionService.deleteSection(sectionId);
        return new Result<>(true, HttpStatus.OK.value(), "Deleted section", sectionDtoConverter.createFromEntity(sectionService.getSection(sectionId)));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    // edit/update a section; subject to change depending on what fields could be updated
    // could be improved by adding to SectionService a method that takes the Dto as parameter
    public Result<SectionDto> updateSection(@RequestBody SectionDto sectionDto) {
        var section = sectionService.updateSection(sectionDtoConverter.createFromDto(sectionDto));
        return new Result<>(true, HttpStatus.OK.value(), "Updated section", sectionDtoConverter.createFromEntity(section));
    }

    @GetMapping("/incomplete")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    // get all sections that are incomplete
    public Result<List<SectionDto>> getIncompleteSections() {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all incomplete sections", sectionService.getIncompleteSections().stream()
                .map(sectionDtoConverter::createFromEntity)
                .collect(Collectors.toList()));
    }

    @GetMapping("/artefacts/{sectionId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    // get all artifacts from a section
    public Result<List<Long>> getArtifactsFromSection(@PathVariable long sectionId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from section", sectionService.getArtifactsFromSection(sectionId)
                .stream()
                .map(Artifact::getId)
                .collect(Collectors.toList())
        );  //todo: return ArtifactDto once it is implemented (or not, depending on what we want)
    }

    @GetMapping("/artefacts")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    // get all artifacts from a section, from a specific archaeologist
    public Result<List<Long>> getArtifactsFromSectionByArchaeologist(@RequestParam long sectionId, @RequestParam long archaeologistId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from section by archaeologist", sectionService.getArtifactsFromSectionByArchaeologist(sectionId, archaeologistId)
                .stream()
                .map(Artifact::getId)
                .collect(Collectors.toList()));
    }
}
