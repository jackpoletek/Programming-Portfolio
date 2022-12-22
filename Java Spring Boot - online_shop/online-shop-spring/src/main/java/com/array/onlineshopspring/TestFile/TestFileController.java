package com.array.onlineshopspring.TestFile;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@ResponseBody
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
@RequestMapping(path = "/files")
public class TestFileController {

    private final TestFileService fileService;

    public TestFileController(TestFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {

        TestFileDTO image = fileService.saveFile(file);

        String downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(String.valueOf(image.getFileId()))
                .toUriString();

        return new ResponseData(image.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }

    //WORKS!!
    @GetMapping(value = "/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer fileId) throws Exception {

        TestFileDTO image = fileService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "image; filename=\"" + image.getFileName()
                                + "\"")
                .body(new ByteArrayResource(image.getData()));
    }

    // Downloads file
    @GetMapping(value = "/show-file/{fileId}")
    public ResponseEntity<byte[]> displayFileAsImage(@PathVariable("fileId") Integer fileId) throws Exception, IOException {

        TestFileDTO image = fileService.getFile(fileId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFileName() + "\"")
                .body(image.getData());
    }

    //WORKS => json array
    @GetMapping("/all-files")
    public ResponseEntity<List<ResponseData>> getAllFiles() {

        List<ResponseData> files = fileService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/")
                    .path(String.valueOf(dbFile.getFileId()))
                    .toUriString();

            return new ResponseData(
                    dbFile.getFileName(),
                    fileDownloadUri,
                    dbFile.getFileType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
}
