package ro.ubb.abc2024.utils.file;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class FileServiceImplTest {

    private FileServiceImpl fileService;
    private MultipartFile multipartFile;
    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        FileRepository fileRepository = mock(FileRepository.class);
        fileService = new FileServiceImpl(fileRepository);
        multipartFile = mock(MultipartFile.class);

        tempFile = Files.createTempFile("test", ".txt").toFile();
        tempFile.deleteOnExit();
    }

    @Test
    void saveFileSuccessfully() throws IOException {
        when(multipartFile.getOriginalFilename()).thenReturn("test.txt");
        when(multipartFile.getInputStream()).thenReturn(new FileInputStream(tempFile));

        String result = fileService.saveFile(multipartFile, "user1");

        assertTrue(result.contains("user1" + File.separator + "test.txt"));
        assertTrue(new File(result).exists());
    }

    @Test
    void saveFileThrowsSecurityExceptionForUnsupportedFilename() throws IOException {
        when(multipartFile.getOriginalFilename()).thenReturn("../test.txt");
        when(multipartFile.getInputStream()).thenReturn(new FileInputStream(tempFile));

        assertThrows(SecurityException.class, () -> fileService.saveFile(multipartFile, "user1"));
    }

    @Test
    void getFileSuccessfully() {
        File file = new File("files/test.txt");
        try {
            Files.createDirectories(Path.of("files"));
            Files.write(file.toPath(), "test content".getBytes());
        } catch (IOException e) {
            fail("Setup failed: " + e.getMessage());
        }

        File result = fileService.getFile("test.txt");

        assertEquals(file.getPath(), result.getPath());
    }

    @Test
    void getFileThrowsNullPointerExceptionWhenFilenameIsNull() {
        assertThrows(NullPointerException.class, () -> fileService.getFile(null));
    }

    @Test
    void getFileThrowsFileNotFoundExceptionWhenFileDoesNotExist() {
        assertThrows(RuntimeException.class, () -> fileService.getFile("nonexistent.txt"));
    }

    @Test
    void getFileThrowsSecurityExceptionForUnsupportedFilename() {
        assertThrows(SecurityException.class, () -> fileService.getFile("../test.txt"));
    }
}