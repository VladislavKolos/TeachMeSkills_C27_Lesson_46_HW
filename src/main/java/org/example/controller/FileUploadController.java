package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.service.FileUploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller for processing requests to upload files.
 */
@Tag(name = "File Upload API", description = "API for uploading files")
@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;

    /**
     * Method for uploading a file.
     * @param multipartFile file to upload
     * @return ResponseEntity with confirmation of successful upload
     */
    @Operation(summary = "Upload a file")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile multipartFile) {
        fileUploadService.uploadFile(multipartFile);

        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }
}