package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.artifact.ImageToArtifact;
import ro.ubb.abc2024.arheo.repository.ArtifactRepository;
import ro.ubb.abc2024.arheo.repository.ImageToArtifactRepository;
import ro.ubb.abc2024.utils.file.DbFile;
import ro.ubb.abc2024.utils.file.FileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArtifactFilesServiceImpl implements ArtifactFilesService{
    private final ArtifactRepository artifactRepository;
    private final FileRepository fileRepository;
    private final ImageToArtifactRepository imageToArtifactRepository;
    private static final String IMAGE_MIME_TYPE_PREFIX = "image/";

    @Override
    public void addImageToArtifact(Long artifactId, UUID fileId) {
        Artifact artifact = artifactRepository.findById(artifactId)
                .orElseThrow(() -> new EntityNotFoundException("Artifact not found"));

        DbFile image = fileRepository.findById(fileId)
                .orElseThrow(() -> new EntityNotFoundException("File not found"));

        if (!isImageFile(image)) {
            throw new IllegalArgumentException("File is not an image.");
        }

        ImageToArtifact imageToArtifact = ImageToArtifact.builder()
                .artifact(artifact)
                .dbFile(image)
                .build();
        imageToArtifactRepository.save(imageToArtifact);
    }

    @Override
    public void add3DModeloArtifact(Long artifactId, UUID fileId) {
        Artifact artifact = artifactRepository.findById(artifactId)
                .orElseThrow(() -> new EntityNotFoundException("Artifact not found"));

        DbFile model3D = fileRepository.findById(fileId)
                .orElseThrow(() -> new EntityNotFoundException("File not found"));

        artifact.setModel3D(model3D);
        artifactRepository.save(artifact);
    }

    @Override
    public void addThumbnailToArtifact(Long artifactId, UUID fileId) {
        Artifact artifact = artifactRepository.findById(artifactId)
                .orElseThrow(() -> new EntityNotFoundException("Artifact not found"));

        DbFile thumbnail = fileRepository.findById(fileId)
                .orElseThrow(() -> new EntityNotFoundException("File not found"));

        if (!isImageFile(thumbnail)) {
            throw new IllegalArgumentException("File is not an image.");
        }

        artifact.setThumbnail(thumbnail);
        artifactRepository.save(artifact);
    }

    @Override
    public boolean isImageFile(DbFile file) {
        return file.getType() != null && file.getType().startsWith(IMAGE_MIME_TYPE_PREFIX);
    }

    @Override
    public List<DbFile> getAvailableImages() {
        List<DbFile> allImageFiles = fileRepository.findAll()
                .stream()
                .filter(this::isImageFile)
                .toList();

        // retrieve all images associated with artifacts in ImageToArtifacts
        List<UUID> usedImageIds = imageToArtifactRepository.findAll()
                .stream()
                .map(imageToArtifact -> imageToArtifact.getDbFile().getId())
                .toList();

        // retrieve all thumbnails already used for artifacts
        List<UUID> thumbnailIds = artifactRepository.findAll()
                .stream()
                .map(Artifact::getThumbnail)
                .filter(Objects::nonNull)
                .map(DbFile::getId)
                .toList();

        List<UUID> usedIds = new ArrayList<>(usedImageIds);
        usedIds.addAll(thumbnailIds);

        // return only the images that are not associated with any artifacts
        return allImageFiles.stream()
                .filter(imageFile -> !usedIds.contains(imageFile.getId()))
                .collect(Collectors.toList());
    }
}
