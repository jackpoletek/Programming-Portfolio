//package com.array.onlineshopspring.service.serviceimpl;
//
//import com.array.onlineshopspring.service.FileService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.UUID;
//
//@Service
//public class FileServiceImpl implements FileService {
//
//    @Override
//    public String uploadImage(String path, MultipartFile file) throws IOException {
//
//        // File name
//        String name = file.getOriginalFilename();
//
//        // Generate random file name
//        String randomId = UUID.randomUUID().toString();
//        assert name != null;
//        String fileName = randomId.concat(name.substring(name.lastIndexOf("")));
//
//        // Full path
//        String filePath = path + File.separator + fileName;
//
//        // Create folder if not yet created
//        File f = new File(path);
//        if (!f.exists()) {
//            f.mkdir();
//        }
//
//        // Copy file
//        Files.copy(file.getInputStream(), Paths.get(filePath));
//
//        return fileName;
//    }
//
//    @Override
//    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
//
//        String fullPath = path + File.separator + fileName;
//
//        InputStream isPresent = new FileInputStream(fullPath);
//
//        // DB logic to return InputStream
//
//        return isPresent;
//    }
//}
