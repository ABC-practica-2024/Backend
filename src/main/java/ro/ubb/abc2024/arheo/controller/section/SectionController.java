package ro.ubb.abc2024.arheo.controller.section;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.controller.utils.HelperMethods;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.service.SectionService;
import ro.ubb.abc2024.arheo.service.SiteService;
import ro.ubb.abc2024.arheo.utils.converter.ArtifactDtoConverter;
import ro.ubb.abc2024.arheo.utils.converter.SectionDtoConverter;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactDto;
import ro.ubb.abc2024.arheo.utils.dto.SectionDto;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.utils.dto.Result;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/sections")
@SecurityRequirement(name = "bearerAuth")
public class SectionController {
    private final SectionService sectionService;
    private final SiteService siteService;
    private final SectionDtoConverter sectionDtoConverter;
    private final ArtifactDtoConverter artifactDtoConverter;
    private final UserService userService;


    private boolean checkIfCurrentUserIsMainArchaeologist(Section section) {
        var userId = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        var mainArchaeologistId = sectionService.getSection(section.getSite().getMainArchaeologist().getId())
                .getSite().getMainArchaeologist().getId();
        return Objects.equals(userId, mainArchaeologistId);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    public Result<Map<String, Object>> getSections(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) String sectionName,
            @RequestParam(required = false) Long siteId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Double minDepth,
            @RequestParam(required = false) Double maxDepth){

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Section> sectionsPage = sectionService.findAllByCriteria(sectionId, sectionName, siteId, status, minDepth, maxDepth, pageable);
        Map<String, Object> response = HelperMethods.makeResponse(sectionsPage, sectionDtoConverter);
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all sections based on params", response);
    }

    // get by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    public Result<SectionDto> getSection(@PathVariable long id) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved section", sectionDtoConverter.createFromEntity(sectionService.getSection(id)));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO')")
    // add a new section, add it to the list of sections
    public Result<SectionDto> addSection(@RequestBody SectionDto sectionDto) {
        if(!HelperMethods.isMainArchaeologistBySiteId(userService, siteService, sectionDto.siteId())){
            return new Result<>(false, HttpStatus.FORBIDDEN.value(), "Only the main archaeologist of the site can add sections", null);
        }

        var section = sectionService.addSection(sectionDtoConverter.createFromDto(sectionDto));
        return new Result<>(true, HttpStatus.CREATED.value(), "Added section", sectionDtoConverter.createFromEntity(section));
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO')")
    public Result<SectionDto> removeSection(@RequestParam long sectionId){
        // given a section id, remove the section from the list of sections
        // only the main archaeologist of the site can delete sections
        var section = sectionService.getSection(sectionId);
        if(!HelperMethods.isMainArchaeologistBySectionId(userService, sectionService, sectionId))
            return new Result<>(false, HttpStatus.FORBIDDEN.value(), "Only the main archaeologist of the site can delete sections", null);

        sectionService.deleteSection(sectionId);
        return new Result<>(true, HttpStatus.OK.value(), "Deleted section", sectionDtoConverter.createFromEntity(section));
    }


    @PutMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO')")
    // edit/update a section; subject to change depending on what fields could be updated
    // only the main archaeologist of the site can update sections
    public Result<SectionDto> updateSection(@RequestBody SectionDto sectionDto) {
        var section = sectionService.getSection(sectionDto.id());
      
        if (!HelperMethods.isMainArchaeologistBySectionId(userService, sectionService, section.getId()))
            return new Result<>(false, HttpStatus.FORBIDDEN.value(), "Only the main archaeologist of the site can update sections", null);

        section = sectionService.updateSection(sectionDtoConverter.createFromDto(sectionDto));

        return new Result<>(true, HttpStatus.OK.value(), "Updated section", sectionDtoConverter.createFromEntity(section));
    }

    // Why would this be here and not in the ArtifactController?
    @GetMapping("/artefacts/{sectionId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    // get all artifacts from a section
    public Result<List<ArtifactDto>> getArtifactsFromSection(@PathVariable long sectionId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from section", sectionService.getArtifactsFromSection(sectionId).stream()
                .map(artifactDtoConverter::createFromEntity)
                .collect(Collectors.toList()));
    }

    // Why would this be here and not in the ArtifactController?
    @GetMapping("/artefacts")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    // get all artifacts from a section, from a specific archaeologist
    public Result<List<ArtifactDto>> getArtifactsFromSectionByArchaeologist(@RequestParam long sectionId, @RequestParam long archaeologistId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from section", sectionService.getArtifactsFromSectionByArchaeologist(sectionId, archaeologistId).
                stream()
                .map(artifactDtoConverter::createFromEntity)
                .collect(Collectors.toList()));
    }

    // change section status
    @PutMapping("/status")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO')")
    public Result<SectionDto> changeSectionStatus(@RequestParam long sectionId, @RequestParam String status){
        var section = sectionService.getSection(sectionId);
        if (!HelperMethods.isMainArchaeologistBySectionId(userService, sectionService, section.getId()))
            return new Result<>(false, HttpStatus.FORBIDDEN.value(), "Only the main archaeologist of the site can update sections", null);

        section.setStatus(SectionStatus.valueOf(status));
        section.setUpdatedAt(LocalDateTime.now());
        section = sectionService.updateSection(section);
        return new Result<>(true, HttpStatus.OK.value(), "Updated section status", sectionDtoConverter.createFromEntity(section));
    }

}