package org.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Service for downloading files.
 */
@Service
@RequiredArgsConstructor
public class FileDownloadService {
    private final Path path = Paths.get("src/main/resources/download");

    /**
     * Method for getting a file resource by its name.
     * @param fileName fileName name of the file to download
     * @return Resource object representing a file
     */
    public Resource downloadFile(String fileName) {
        try {
            Path downloadPath = path.resolve(fileName);
            Resource resource = new UrlResource(downloadPath.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("The file does not exist or cannot be read");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("The file does not exist or cannot be read");
        }
    }
}