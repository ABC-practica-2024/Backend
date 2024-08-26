package ro.ubb.abc2024.utils.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {

     String saveFile(MultipartFile fileToSave, String username);
     File getFile(String fileName);
}
