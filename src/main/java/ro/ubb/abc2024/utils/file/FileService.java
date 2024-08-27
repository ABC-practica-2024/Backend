package ro.ubb.abc2024.utils.file;

import org.springframework.web.multipart.MultipartFile;
import ro.ubb.abc2024.utils.dto.FileDto;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public interface FileService {

     String saveFile(MultipartFile fileToSave, String username);
     File getFile(String fileName);
     File downloadFile(UUID uuid);
     String storeFileIntoDb(FileDto fileToSave) throws IOException;
}
