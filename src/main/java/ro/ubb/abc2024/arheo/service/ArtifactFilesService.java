package ro.ubb.abc2024.arheo.service;

import ro.ubb.abc2024.utils.file.DbFile;

import java.util.List;
import java.util.UUID;

public interface ArtifactFilesService {
    void addImageToArtifact(Long artifactId, UUID fileId);
    void addThumbnailToArtifact(Long artifactId, UUID fileId);
    void add3DModeloArtifact(Long artifactId, UUID fileId);
    boolean isImageFile(DbFile file);
    List<DbFile> getAvailableImages();
    // a method that works by the same logic will be implemented when actual 3D models will be stored in the DB
    // I suppose methods for removing files will be added later
}
