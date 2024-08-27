package ro.ubb.abc2024.utils.file;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.ubb.abc2024.utils.dto.FileDto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService{
    private final FileRepository fileRepository;
    private static final String DIRECTORY = "files";

    @Override
    public String saveFile(MultipartFile fileToSave, String username) {
        if (fileToSave == null){
            throw new NullPointerException("File to save is null");
        }
       var path = DIRECTORY + File.separator + username ;
        try {
            Files.createDirectories(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var targetFile = new File(path + File.separator + fileToSave.getOriginalFilename());
        if (!Objects.equals(targetFile.getParent(), DIRECTORY + File.separator + username)){
            throw new SecurityException("Unsupported filename");
        }
        try {
            Files.copy(fileToSave.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return targetFile.getPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getFile(String fileName) {
        if (fileName == null){
            throw new NullPointerException("Filename is null!");
        }
        var fileToDownload = new File(DIRECTORY + File.separator + fileName);
        if (!fileToDownload.getParent().startsWith(DIRECTORY)){
            throw new SecurityException("Unsupported filename!");
        }
        System.out.println(fileToDownload.getPath());
        if (!fileToDownload.exists()){
            try {
                throw new FileNotFoundException("No file found.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return fileToDownload;
    }

    @Override
    public File downloadFile(UUID uuid) {
        DbFile file = fileRepository.findById(uuid).orElseThrow(() ->new EntityNotFoundException(String.format("File with uuid: %s, not found", uuid)));

        var fileToDownload = new File(file.getPath());
        if (!fileToDownload.exists()){
            try {
                throw new FileNotFoundException("No file found.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return fileToDownload;
    }


    @Override
    public String storeFileIntoDb(FileDto fileToSave) {
        DbFile file = DbFile
                .builder()
                .name(fileToSave.multipartFile().getOriginalFilename())
                .path(DIRECTORY + File.separator + fileToSave.folder())
                .type(fileToSave.multipartFile().getContentType()).build();

        var path = file.getPath();
        var savedFile = this.fileRepository.save(file);

        try {
            Files.createDirectories(Path.of(path));
        } catch (IOException e) {
            fileRepository.delete(savedFile);
            throw new RuntimeException(e);
        }

        var targetFile = new File(path + File.separator + savedFile.getId());

        try {
            Files.copy(fileToSave.multipartFile().getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            fileRepository.delete(savedFile);
            throw new RuntimeException(e);
        }

        return String.valueOf(savedFile.getId());
    }
}
