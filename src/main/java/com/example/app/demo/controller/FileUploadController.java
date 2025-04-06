// package com.example.app.demo.controller;

// import com.example.app.demo.service.StorageService;

// import java.io.IOException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;

// @RestController
// @RequestMapping("/api")
// public class FileUploadController {

//     @Autowired
//     private StorageService storageService;

//     @PostMapping("/upload")
//     public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) throws IOException {
//         // Upload file and get URL
//         String fileUrl = storageService.uploadFile(file);
//         return new FileUploadResponse(fileUrl);
//     }

//     public static class FileUploadResponse {
//         private String fileUrl;

//         public FileUploadResponse(String fileUrl) {
//             this.fileUrl = fileUrl;
//         }

//         public String getFileUrl() {
//             return fileUrl;
//         }

//         public void setFileUrl(String fileUrl) {
//             this.fileUrl = fileUrl;
//         }
//     }
// }
