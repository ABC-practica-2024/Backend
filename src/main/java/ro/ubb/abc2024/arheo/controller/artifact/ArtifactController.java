package ro.ubb.abc2024.arheo.controller.artifact;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.service.ArtifactService;
import ro.ubb.abc2024.arheo.utils.converter.ArtifactDtoConverter;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactDto;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/artifacts")
public class ArtifactController {
    private final ArtifactService artifactService;
    private final ArtifactDtoConverter artifactDtoConverter;
    private final UserService userService;

    // get all artifacts
    /*@GetMapping
    public Result<List<ArtifactDto>> getArtifacts() {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts", artifactService.getAllArtifacts().stream()
                .map(artifactDtoConverter::createFromEntity)
                .collect(Collectors.toList()));
    }*/

    // get all artifacts paginated and filtered by whatever fields we want
    @GetMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN', 'SCOPE_BIO')")
    public Result<Map<String,Object>> getArtifacts(@RequestParam(required = false) Long siteId,
                                                   @RequestParam(required = false) Long sectionId,
                                                   @RequestParam(required = false) Long archaeologistId,
                                                   @RequestParam(required = false) String label,
                                                   @RequestParam(required = false) String category,
                                                   @RequestParam(required = false) Boolean analysisCompleted,
                                                   @RequestParam(required = false) Boolean selfSubmitted,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size) {
        if (selfSubmitted) {
            var currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
            archaeologistId = userService.getUser(currentUser).getId();
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Artifact> artifactPage = artifactService.getAllPaginatedByCriteria(siteId, sectionId, archaeologistId, label, category, analysisCompleted, pageable);
        List<ArtifactDto> artifactDtoList = artifactPage.getContent().stream().map(artifactDtoConverter::createFromEntity)
                .collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        response.put("artifacts", artifactDtoList);
        response.put("currentPage", artifactPage.getNumber());
        response.put("totalItems", artifactPage.getTotalElements());
        response.put("totalPages", artifactPage.getTotalPages());
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts", response);
    }

    // get an artifact by its id
    @GetMapping("/{id}")
    public Result<ArtifactDto> getArtifactById(@PathVariable long id) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved artifact", artifactDtoConverter.createFromEntity(artifactService.getArtifactById(id)));
    }

    // add a new artifact
    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<ArtifactDto> addArtifact(@RequestBody ArtifactDto artifactDto) {
        Long sectionId = artifactDto.sectionId();
        Long mainArchaeologistId = artifactService.getMainArchaeologistIdFromSectionId(sectionId);
        List<Long> assignedArchaeologistIds = artifactService.getAssignedArchaeologistIdsBySectionId(sectionId);

        var currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Long currentUserId = userService.getUser(currentUser).getId();

        if (!mainArchaeologistId.equals(currentUserId) || !assignedArchaeologistIds.contains(currentUserId)) {
            return new Result<>(false, HttpStatus.FORBIDDEN.value(), "You do not have permission to add this artifact", null);
        }
        var artifact = artifactService.addArtifact(artifactDtoConverter.createFromDto(artifactDto));
        return new Result<>(true, HttpStatus.CREATED.value(), "Added artifact", artifactDtoConverter.createFromEntity(artifact));
    }

    // delete an artifact
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<Void> deleteArtifact(@PathVariable long id) {
        Artifact existingArtifact = artifactService.getArtifactById(id);
        Long mainArchaeologistId = artifactService.getMainArchaeologistIdFromArtifactId(existingArtifact.getId());

        var currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Long currentUserId = userService.getUser(currentUser).getId();

        if (!existingArtifact.getArcheologist().getId().equals(currentUserId) || !mainArchaeologistId.equals(currentUserId)) {
            return new Result<>(false, HttpStatus.FORBIDDEN.value(), "You do not have permission to delete this artifact", null);
        }
        artifactService.deleteArtifact(id);
        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Deleted artifact", null);
    }

    // update an artifact
    @PutMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<ArtifactDto> updateArtifact(@RequestBody ArtifactDto artifactDto) {
        Artifact existingArtifact = artifactService.getArtifactById(artifactDto.id());
        Long mainArchaeologistId = artifactService.getMainArchaeologistIdFromArtifactId(existingArtifact.getId());

        var currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Long currentUserId = userService.getUser(currentUser).getId();

        if (!existingArtifact.getArcheologist().getId().equals(currentUserId) || !mainArchaeologistId.equals(currentUserId)) {
            return new Result<>(false, HttpStatus.FORBIDDEN.value(), "You do not have permission to edit this artifact", null);
        }
        Artifact artifact = artifactService.updateArtifact(artifactDtoConverter.createFromDto(artifactDto));
        return new Result<>(true, HttpStatus.OK.value(), "Updated artifact", artifactDtoConverter.createFromEntity(artifact));
    }

    /*// get all artifacts for an archaeologist
    @GetMapping("/by-archeologist")
    public Result<List<ArtifactDto>> getArtifactsByArcheologistId(@RequestParam Long archaeologistId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts for an archeologist",
                artifactService.getArtifactsByArcheologistId(archaeologistId).stream()
                        .map(artifactDtoConverter::createFromEntity)
                        .collect(Collectors.toList()));
    }

    // get all artifacts which aren't completely analysed
    @GetMapping("/incomplete")
    public Result<List<ArtifactDto>> getIncompleteArtifacts() {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all unanalysed artifacts", artifactService.getUnanalysedArtifacts().stream()
                .map(artifactDtoConverter::createFromEntity)
                .collect(Collectors.toList()));
    }

    // get all artifacts by a category
    @GetMapping("/category")
    public Result<List<ArtifactDto>> getArtifactsByCategory(@RequestParam String category) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved artifacts by category",
                artifactService.getArtifactsByCategory(category).stream()
                        .map(artifactDtoConverter::createFromEntity)
                        .collect(Collectors.toList()));
    }

    // get all artifacts from a site, from a specific archaeologist
    @GetMapping("/by-site-and-archaeologist")
    public Result<List<ArtifactDto>> getArtifactsFromSiteByArchaeologist(@RequestParam long siteId, @RequestParam long archaeologistId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from site by archaeologist",
                artifactService.getArtifactsBySiteIdAndArcheologistId(siteId, archaeologistId)
                        .stream()
                        .map(artifactDtoConverter::createFromEntity)
                        .collect(Collectors.toList()));
    }

    // get all artifacts from a site
    @GetMapping("/by-site")
    public Result<List<ArtifactDto>> getArtifactsFromSite(@RequestParam long siteId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from site",
                artifactService.getArtifactsBySiteId(siteId).stream()
                        .map(artifactDtoConverter::createFromEntity)
                        .collect(Collectors.toList()));
    }

    // get all artifacts from a section
    @GetMapping("/by-section")
    public Result<List<ArtifactDto>> getArtifactsFromSection(@RequestParam long sectionId) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts from section",
                artifactService.getArtifactsBySectionId(sectionId).stream()
                        .map(artifactDtoConverter::createFromEntity)
                        .collect(Collectors.toList()));
    }*/
}
