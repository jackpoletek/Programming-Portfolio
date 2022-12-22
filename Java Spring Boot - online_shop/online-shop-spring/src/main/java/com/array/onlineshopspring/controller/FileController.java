//package com.array.onlineshopspring.controller;
//
//import com.array.onlineshopspring.helper.FileUploadHelper;
//import com.array.onlineshopspring.payload.FileResponse;
//import com.array.onlineshopspring.service.FileService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StreamUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Objects;
//
//@RestController
//@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200/")
//@RequestMapping(value = "/api/v1/files")
//public class FileController {
//
//    private final FileService fileService;
//    private final FileUploadHelper uploadHelper;
//
////    "src/main/resources/images/Cinderella_tree.jpg"
//    @Value("${root-dir}")
//    private final String path;
//
//    public FileController(FileService fileService, FileUploadHelper uploadHelper, String path) {
//        this.fileService = fileService;
//        this.uploadHelper = uploadHelper;
//        this.path = path;
//    }
//
//    @PostMapping(value = "upload-image")
//    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {
//
//        try {
//            // Validation
//            if (image.isEmpty()) {
//                return new ResponseEntity<>(new FileResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Request must contain image").getStatus());
//            }
//            if (!Objects.equals(image.getContentType(), "image/jpeg")) {
//                return new ResponseEntity<>(new FileResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Only JPEG content type allowed").getStatus());
//            }
//            // File upload
//            boolean uploaded = uploadHelper.isUploaded(image);
//            if (!uploaded) {
//                return new ResponseEntity<>(new FileResponse("File name not found", "Failed to upload image"), HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(new FileResponse(String.valueOf(image), "Image successfully uploaded"), HttpStatus.OK);
//
//        // todo Previous version:
////        String fileName;
////        try {
////            fileName = fileService.uploadImage(path, image);
////
////            // Call repo +
////            // Save fileName
////        } catch (IOException e) {
////            e.printStackTrace();
////            return new ResponseEntity<>(new FileResponse("file name not found", "Failed to upload image"), HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////        return new ResponseEntity<>(new FileResponse(fileName, "Image successfully uploaded"), HttpStatus.OK);
//    }
//
//    @GetMapping(value = "product/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public void downloadImage(@PathVariable("imageName") String imageName,
//                              HttpServletResponse response) throws IOException {
//
//        InputStream resource = fileService.getResource(path, imageName);
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        StreamUtils.copy(resource, response.getOutputStream());
//    }
//
//}
