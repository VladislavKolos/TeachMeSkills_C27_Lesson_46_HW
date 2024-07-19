package org.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Service for uploading files.
 */
@Service
@RequiredArgsConstructor
public class FileUploadService {
    private final Path path = Paths.get("src/main/resources/uploaded");

    /**
     * Method for uploading a file to a directory.
     * @param multipartFile file to be loaded
     */
    public void uploadFile(MultipartFile multipartFile) {
        try {
            if (!Files.exists(path)) {
                init();
            }

            if (multipartFile != null) {
                Path uploadPath = this.path.resolve(
                                Paths.get(multipartFile.getOriginalFilename()))
                        .normalize()
                        .toAbsolutePath();

                Files.copy(multipartFile.getInputStream(), uploadPath);
            } else {
                throw new RuntimeException("Failed to upload file");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file");
        }
    }

    /**
     * Method for creating a directory if it does not exist.
     */
    private void init() {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize storage");
        }
    }
}