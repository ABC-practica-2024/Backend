package ro.ubb.abc2024.arheo.controller.artifact;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.service.ArtifactService;
import ro.ubb.abc2024.arheo.utils.converter.ArtifactDtoConverter;
import ro.ubb.abc2024.arheo.utils.dto.ArtifactDto;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/artifacts")
public class ArtifactController {
    private final ArtifactService artifactService;
    private final ArtifactDtoConverter artifactDtoConverter;

    // get all artifacts
    @GetMapping
    public Result<List<ArtifactDto>> getArtifacts() {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all artifacts", artifactService.getAllArtifacts().stream()
                .map(artifactDtoConverter::createFromEntity)
                .collect(Collectors.toList()));
    }

    // get an artifact by its id
    @GetMapping("/{id}")
    public Result<ArtifactDto> getArtifactById(@PathVariable long id) {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved artifact", artifactDtoConverter.createFromEntity(artifactService.getArtifactById(id)));
    }

    // add a new artifact
    @PostMapping
    public Result<ArtifactDto> addArtifact(@RequestBody ArtifactDto artifactDto) {
        var artifact = artifactService.addArtifact(artifactDtoConverter.createFromDto(artifactDto));
        return new Result<>(true, HttpStatus.CREATED.value(), "Added artifact", artifactDtoConverter.createFromEntity(artifact));
    }

    // delete an artifact
    @DeleteMapping("/{id}")
    public Result<Void> deleteArtifact(@PathVariable long id) {
        artifactService.deleteArtifact(id);
        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Deleted artifact", null);
    }

    // update an artifact
    @PutMapping
    public Result<ArtifactDto> updateArtifact(@RequestBody ArtifactDto artifactDto) {
        var artifact = artifactService.updateArtifact(artifactDtoConverter.createFromDto(artifactDto));
        return new Result<>(true, HttpStatus.OK.value(), "Updated artifact", artifactDtoConverter.createFromEntity(artifact));
    }

    // get all artifacts for an archaeologist
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
    }
}
