package com.array.onlineshopspring.service;

import com.array.onlineshopspring.model.Image;
import org.springframework.http.RequestEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
	
    String uploadFile(MultipartFile file);
    RequestEntity.BodyBuilder uploadImage(MultipartFile imageFile) throws IOException;
    Image getImageById(Integer imageId);
    List<Image> getAllImages();
    Image getImageById2(Integer imageId);
}
