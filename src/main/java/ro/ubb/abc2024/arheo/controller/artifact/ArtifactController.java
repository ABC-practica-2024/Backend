package ro.ubb.abc2024.arheo.controller.artifact;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.controller.utils.HelperMethods;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.service.ArtifactService;
import ro.ubb.abc2024.arheo.utils.converter.ArtifactDtoConverter;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactDto;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/artifacts")
@SecurityRequirement(name = "bearerAuth")
public class ArtifactController {

    private final ArtifactService artifactService;
    private final ArtifactDtoConverter artifactDtoConverter;
    private final UserService userService;

    // get all artifacts paginated and filtered by whatever fields we want
    @GetMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN', 'SCOPE_BIO')")
    public Result<Map<String, Object>> getArtifacts(
            @RequestParam(required = false) Long artifactId,
            @RequestParam(required = false) Long siteId,
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) Long archaeologistId,
            @RequestParam(required = false) String label,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean analysisCompleted,
            @RequestParam(required = true) Boolean selfSubmitted,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "false") boolean all) {

        // if selfSubmitted is true, set archaeologistId to the current user's ID
        if (selfSubmitted) {
            archaeologistId = HelperMethods.getCurrentUserId(userService);
        }

        Pageable pageable = all ? Pageable.unpaged() : PageRequest.of(page, size);

        Page<Artifact> artifactPage = artifactService.getAllPaginatedByCriteria(
                artifactId, siteId, sectionId, archaeologistId, label, category, analysisCompleted, pageable
        );

        Map<String, Object> response = HelperMethods.makeResponse(artifactPage, artifactDtoConverter);
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts", response);
    }

    // add a new artifact
    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<ArtifactDto> addArtifact(@RequestBody ArtifactDto artifactDto) {
        Long currentUserId = HelperMethods.getCurrentUserId(userService);

        // if not an admin, check if the user has permission to add an artifact
        if (!HelperMethods.isAdmin()) {
            Long sectionId = artifactDto.sectionId();
            Long mainArchaeologistId = HelperMethods.getMainArchaeologistIdBySectionId(artifactService, sectionId);
            List<Long> assignedArchaeologistIds = HelperMethods.getAssignedArchaeologists(artifactService, sectionId);

            // check if the current user is the main archaeologist or assigned to the site
            if (!mainArchaeologistId.equals(currentUserId) && !assignedArchaeologistIds.contains(currentUserId)) {
                return new Result<>(false, HttpStatus.FORBIDDEN.value(), "You do not have permission to add this artifact", null);
            }
        }

        // ensure the "archaeologistId" field has the value of the current user's id
        User currentArchaeologist = userService.getUser(currentUserId);
        Artifact artifact = artifactService.addArtifact(artifactDtoConverter.createFromDto(artifactDto), currentArchaeologist);

        return new Result<>(true, HttpStatus.CREATED.value(), "Added artifact", artifactDtoConverter.createFromEntity(artifact));
    }

    // delete an artifact
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<Void> deleteArtifact(@PathVariable long id) {
        Artifact existingArtifact = artifactService.getArtifactById(id);
        Long currentUserId = HelperMethods.getCurrentUserId(userService);

        // if not an admin, check if the user has permission to delete an artifact
        if (!HelperMethods.isAdmin()) {
            Long mainArchaeologistId = HelperMethods.getMainArchaeologistIdByArtifactId(artifactService, existingArtifact.getId());

            // check if the current user is the one that added the artifact or the main archaeologist
            if (!existingArtifact.getArcheologist().getId().equals(currentUserId) && !mainArchaeologistId.equals(currentUserId)) {
                return new Result<>(false, HttpStatus.FORBIDDEN.value(), "You do not have permission to delete this artifact", null);
            }
        }

        artifactService.deleteArtifact(id);
        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Deleted artifact", null);
    }

    // update an artifact
    @PutMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<ArtifactDto> updateArtifact(@RequestBody ArtifactDto artifactDto) {
        Artifact existingArtifact = artifactService.getArtifactById(artifactDto.id());
        Long currentUserId = HelperMethods.getCurrentUserId(userService);

        // if not an admin, check if the user has permission to delete an artifact
        if (!HelperMethods.isAdmin()) {
            Long mainArchaeologistId = HelperMethods.getMainArchaeologistIdByArtifactId(artifactService, existingArtifact.getId());

            // check if the current user is the one that added the artifact or the main archaeologist
            if (!existingArtifact.getArcheologist().getId().equals(currentUserId) && !mainArchaeologistId.equals(currentUserId)) {
                return new Result<>(false, HttpStatus.FORBIDDEN.value(), "You do not have permission to edit this artifact", null);
            }
        }

        Artifact artifact = artifactService.updateArtifact(artifactDtoConverter.createFromDto(artifactDto));
        return new Result<>(true, HttpStatus.OK.value(), "Updated artifact", artifactDtoConverter.createFromEntity(artifact));
    }
}
