//package com.array.onlineshopspring.helper;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//public class FileUploadHelper {
//
//    public final String UPLOAD_DIR = "src/main/resources/images";
////            "F:/AA_CODING/JAVA-Full-Stack-Spring-React/online-shop-spring/online-shop-spring/src/main/resources/images"
//
//    public boolean isUploaded(MultipartFile file) {
//
//        boolean fileUploaded = false;
//
//        try {
////            InputStream is = file.getInputStream();
////            byte[] data = new byte[is.available()];
////
////            int read = is.read(data);
////
////            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + file.getOriginalFilename());
////            fos.write(read); // OR fos.write(data);
////
////            fos.flush();
////            fos.close();
//
//            // Another method
//            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//
//            fileUploaded = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fileUploaded;
//    }
//}
