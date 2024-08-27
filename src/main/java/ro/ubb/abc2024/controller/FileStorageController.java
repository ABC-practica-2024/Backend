package ro.ubb.abc2024.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.ubb.abc2024.utils.dto.FileDto;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.utils.file.FileService;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@RestController()
@RequestMapping("${api.endpoint.base-url}/files")
@SecurityRequirement(name = "bearerAuth")
public class FileStorageController {

    private final FileService fileService;

    @PostMapping("/upload")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO')")
    public Result<String> storeFilesIntoDB(@RequestParam("file") FileDto file){

        var savedFileId = this.fileService.storeFileIntoDb(file);
        return new Result<>(true, HttpStatus.OK.value(),String.format("File with id %s uploaded to the database successfully", savedFileId));
    }

    @GetMapping("/download")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO')")
    public ResponseEntity<Resource> downloadFile(@RequestParam("file") UUID uuid) {
        var downloadedFile = this.fileService.downloadFile(uuid);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + downloadedFile.getName() + "\"")
                .contentLength(downloadedFile.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(downloadedFile));
    }
}
