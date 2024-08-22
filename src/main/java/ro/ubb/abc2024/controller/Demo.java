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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.utils.file.FileService;

@RequiredArgsConstructor
@RestController()
@RequestMapping("${api.endpoint.base-url}/demo")
@SecurityRequirement(name = "bearerAuth")
public class Demo {

    private final FileService fileService;

    @GetMapping("/guest")
    @PreAuthorize("hasAuthority('SCOPE_GUEST')")
    public String hello() {
        return "Hello Guest!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<String> helloAdmin(){
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new Result<>(true,HttpStatus.OK.value(),String.format("Hello %s. You have admin rights.", username), null);
    }

    @GetMapping("/arheo")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ARH_PRIME')")
    public String helloArheo(){
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format("Hello %s. You have archeology rights.", username);
    }

    @GetMapping("/bio")
    @PreAuthorize("hasAnyAuthority('SCOPE_BIO', 'SCOPE_BIO_PRIME')")
    public String helloBio(){
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format("Hello %s. You have biology rights.", username);
    }

    @PostMapping("/upload")
//    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file) {
        this.fileService.saveFile(file, "testUser");
        return new Result<>(true, HttpStatus.OK.value(), "File uploaded.");
    }

    @GetMapping("/download")
//    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Resource> downloadFile(@RequestParam("file") String filename) {
        var downloadedFile = this.fileService.getFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .contentLength(downloadedFile.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(downloadedFile));
    }

}
