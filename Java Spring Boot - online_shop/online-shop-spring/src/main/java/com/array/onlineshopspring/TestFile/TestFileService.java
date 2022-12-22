package com.array.onlineshopspring.TestFile;

import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Stream;

public interface TestFileService {
	
    TestFileDTO saveFile(MultipartFile file) throws Exception;
    TestFileDTO getFile(Integer fileId) throws Exception;
    Stream<TestFile> getAllFiles();
}
