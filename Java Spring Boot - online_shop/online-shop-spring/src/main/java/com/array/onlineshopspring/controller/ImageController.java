package com.array.onlineshopspring.controller;

import com.array.onlineshopspring.model.Image;
import com.array.onlineshopspring.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@ResponseBody
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
@RequestMapping(path = "/api/v1/images")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public RequestEntity.BodyBuilder uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        MultipartFile uploadedFile = (MultipartFile) imageService.uploadImage(file);
        return (RequestEntity.BodyBuilder) ResponseEntity.ok(uploadedFile);
    }

    @GetMapping(value = "/all-images")
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.getAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping(path = {"/by-id/{imageId}"})
    public ResponseEntity<Image> getImageById(@PathVariable("imageId") Integer imageId) {
        Image image = imageService.getImageById(imageId);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
    //SHOWS image as base64
    @GetMapping(path = {"/test/{imageId}"})
    public ResponseEntity<Image> getImageById2(@PathVariable("imageId") Integer imageId) {
        Image image = imageService.getImageById2(imageId);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

//    @GetMapping(path = {"/by-name/{imageName}"})
//    public ResponseEntity<Image> getImage(@PathVariable("imageName") String imageName) {
//        Image imName = imageService.getImage(imageName);
//        return ResponseEntity.ok(imName);
//    }

    //    @PostMapping("/upload-file")
//    public String uploadFile(@RequestParam("file") MultipartFile file) {
//        logger.info("FILE IN THE CONTROLLER / file name: " + file.getOriginalFilename());
//        return imageService.uploadFile(file);
//    }
}
