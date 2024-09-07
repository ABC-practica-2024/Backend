package ro.ubb.abc2024.arheo.controller.artifact;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.service.ArtifactFilesService;
import ro.ubb.abc2024.arheo.utils.converter.ArtifactDtoConverter;
import ro.ubb.abc2024.utils.dto.FileDto;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.utils.file.DbFile;
import ro.ubb.abc2024.utils.file.FileRepository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/artifacts/files")
@SecurityRequirement(name = "bearerAuth")
public class ArtifactFilesController {
    private final ArtifactFilesService artifactFilesService;

    @PostMapping("/image")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN', 'SCOPE_BIO')")
    public Result<Void> addImageToArtifact(@RequestParam(required = true) Long artifactId, @RequestParam(required = true) UUID fileId) {
        artifactFilesService.addImageToArtifact(artifactId, fileId);
        return new Result<>(true, HttpStatus.OK.value(), "Image added successfully to artifact.", null);
    }

    @PostMapping("/3d-model")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN', 'SCOPE_BIO')")
    public Result<Void> add3DModelToArtifact(@RequestParam(required = true) Long artifactId, @RequestParam(required = true) UUID fileId) {
        artifactFilesService.add3DModeloArtifact(artifactId, fileId);
        return new Result<>(true, HttpStatus.OK.value(), "3D model added successfully to artifact.", null);
    }

    @PostMapping("/thumbnail")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN', 'SCOPE_BIO')")
    public Result<Void> addThumbnailToArtifact(@RequestParam(required = true) Long artifactId, @RequestParam(required = true) UUID fileId) {
        artifactFilesService.addThumbnailToArtifact(artifactId, fileId);
        return new Result<>(true, HttpStatus.OK.value(), "Thumbnail added successfully to artifact.", null);
    }

    @GetMapping("/images")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN', 'SCOPE_BIO')")
    public Result<List<DbFile>> getAvailableImages() {
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all available images", artifactFilesService.getAvailableImages());
    }
}
