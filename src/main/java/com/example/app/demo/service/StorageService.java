package com.example.app.demo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageService.class);

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    public String uploadFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File cannot be null or empty");
        }

        File fileObj = convertMultiPartFileToFile(file);
        String fileName = generateUniqueFileName(file.getOriginalFilename());
        
        try {
            s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
            String fileUrl = s3Client.getUrl(bucketName, fileName).toString();
            logger.info("File uploaded successfully: {}", fileUrl);
            return fileUrl;
        } finally {
            if (fileObj.exists()) {
                boolean deleted = fileObj.delete();
                if (!deleted) {
                    logger.warn("Failed to delete temporary file: {}", fileObj.getAbsolutePath());
                }
            }
        }
    }

    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }

    private String generateUniqueFileName(String originalFileName) {
        return UUID.randomUUID().toString() + "_" + originalFileName;
    }
}