package ro.ubb.abc2024.utils.dto;

import org.springframework.web.multipart.MultipartFile;

public record FileDto (
        MultipartFile multipartFile,
        String folder
){
}
