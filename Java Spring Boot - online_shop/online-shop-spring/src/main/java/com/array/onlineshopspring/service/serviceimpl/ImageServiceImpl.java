package com.array.onlineshopspring.service.serviceimpl;

import com.array.onlineshopspring.exception.ResourceNotFoundException;
import com.array.onlineshopspring.model.Image;
import com.array.onlineshopspring.repository.ImageRepository;
import com.array.onlineshopspring.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${root-dir}")
    private String rootDir;
    private Path storageLoc;

    @PostConstruct
    public void setPath() {
        this.storageLoc = Paths.get(this.rootDir);
    }
	
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public RequestEntity.BodyBuilder uploadImage(MultipartFile imageFile) throws IOException {
        System.out.println("Original image size in bytes: " + imageFile.getBytes().length);

        Image image = new Image(imageFile.getOriginalFilename(), imageFile.getContentType(),
                compressBytes(imageFile.getBytes()));

        return (RequestEntity.BodyBuilder) imageRepository.save(image);
    }

    @Override
    public Image getImageById(Integer imageId) {
        Optional<Image> retrievedImage = imageRepository.findById(imageId);

        Image image = null;

        if (retrievedImage.isPresent()) {
            image = new Image(retrievedImage.get().getImageName(), retrievedImage.get().getImageType(),
                    retrievedImage.get().getImageByte());
        }

        return image;
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageById2(Integer imageId) {
        return imageRepository.findById(imageId)
                .orElseThrow(()-> new ResourceNotFoundException("Image", "id", imageId));
    }

    @Override
    public String uploadFile(MultipartFile file) {
        logger.info("START: File uploading... / FILE NAME: " + file.getOriginalFilename());
        String fileName = file.getOriginalFilename();

        if (!file.isEmpty()) {

            try(InputStream inputStream = file.getInputStream()) {
                assert fileName != null;
                Files.copy(inputStream, storageLoc.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
                logger.info("FINISH: FILE UPLOADED SUCCESSFULLY!");

            } catch (IOException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }
        }
        return fileName;
    }

    private static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Compressed image size in bytes: " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());

        } catch (DataFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
