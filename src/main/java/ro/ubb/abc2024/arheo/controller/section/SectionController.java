package ro.ubb.abc2024.arheo.controller.section;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.service.SectionService;
import ro.ubb.abc2024.arheo.utils.converter.SectionDtoConverter;
import ro.ubb.abc2024.arheo.utils.dto.SectionDto;
import ro.ubb.abc2024.controller.UserController;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.user.UserServiceImpl;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.arheo.controller.utils.HelperMethods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/sections")
public class SectionController {
    private final SectionService sectionService;
    private final SectionDtoConverter sectionDtoConverter;
    private final UserService userService;

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('ARH')")
    public Result<Map<String, Object>> getSections(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) String sectionName,
            @RequestParam(required = false) Long siteId,
            @RequestParam(required = false) String status) {

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Section> sectionsPage = sectionService.findAllByCriteria(sectionId, sectionName, siteId, status, pageable);
        Map<String, Object> response = HelperMethods.makeResponse(sectionsPage, sectionDtoConverter);
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all sections based on params", response);
    }

    // get by id
    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ARH')")
    public Result<SectionDto> getSection(@PathVariable long id) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved section", sectionDtoConverter.createFromEntity(sectionService.getSection(id)));
    }

    @PostMapping
    //@PreAuthorize("hasAnyAuthority('ARH')")
    // add a new section, add it to the list of sections
    public Result<SectionDto> addSection(@RequestBody SectionDto sectionDto) {
        // TODO: check if current user is mainArchaeologist of the site
        var section = sectionService.addSection(sectionDtoConverter.createFromDto(sectionDto));
        //return sectionDtoConverter.createFromEntity(section);
        return new Result<>(true, HttpStatus.CREATED.value(), "Added section", sectionDtoConverter.createFromEntity(section));
    }

    @DeleteMapping
    //@PreAuthorize("hasAnyAuthority('ARH')")
    public Result<SectionDto> removeSection(@RequestBody long sectionId){
        // given a section id, remove the section from the list of sections
        sectionService.deleteSection(sectionId);
        return new Result<>(true, HttpStatus.OK.value(), "Deleted section", sectionDtoConverter.createFromEntity(sectionService.getSection(sectionId)));
    }

    @PutMapping
    //@PreAuthorize("hasAnyAuthority('ARH')")
    // edit/update a section; subject to change depending on what fields could be updated
    // could be improved by adding to SectionService a method that takes the Dto as parameter
    public Result<SectionDto> updateSection(@RequestBody SectionDto sectionDto) {
        var section = sectionService.updateSection(sectionDtoConverter.createFromDto(sectionDto));
        return new Result<>(true, HttpStatus.OK.value(), "Updated section", sectionDtoConverter.createFromEntity(section));
    }

    @GetMapping("/incomplete")
    //@PreAuthorize("hasAnyAuthority('ARH')")
    // get all sections that are incomplete
    public Result<List<SectionDto>> getIncompleteSections() {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all incomplete sections", sectionService.getIncompleteSections().stream()
                .map(sectionDtoConverter::createFromEntity)
                .collect(Collectors.toList()));
    }

    @GetMapping("/artefacts/{sectionId}")
    //@PreAuthorize("hasAnyAuthority('ARH')")
    // get all artifacts from a section
    public Result<List<Long>> getArtifactsFromSection(@PathVariable long sectionId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from section", sectionService.getArtifactsFromSection(sectionId)
                .stream()
                .map(Artifact::getId)
                .collect(Collectors.toList())
        );  //todo: return ArtifactDto once it is implemented (or not, depending on what we want)
    }

    @GetMapping("/artefacts")
    //@PreAuthorize("hasAnyAuthority('ARH')")
    // get all artifacts from a section, from a specific archaeologist
    public Result<List<Long>> getArtifactsFromSectionByArchaeologist(@RequestParam long sectionId, @RequestParam long archaeologistId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from section by archaeologist", sectionService.getArtifactsFromSectionByArchaeologist(sectionId, archaeologistId)
                .stream()
                .map(Artifact::getId)
                .collect(Collectors.toList()));
    }
}
