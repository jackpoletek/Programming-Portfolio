package com.array.onlineshopspring.TestFile;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.stream.Stream;

@Service
public class TestFileServiceImpl implements TestFileService {

    private final TestFileRepo fileRepo;
    private final ModelMapper modelMapper;

    public TestFileServiceImpl(TestFileRepo fileRepo, ModelMapper modelMapper) {
        this.fileRepo = fileRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public TestFileDTO saveFile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            TestFile image
                    = new TestFile(fileName,
                    file.getContentType(),
                    file.getBytes());
            TestFile newFile = fileRepo.save(image);

            return modelMapper.map(newFile, TestFileDTO.class);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    @Override
    public TestFileDTO getFile(Integer fileId) throws Exception {
        TestFile image = fileRepo
                .findById(fileId)
                .orElseThrow(() -> new Exception("File not found with Id: " + fileId));

        return modelMapper.map(image, TestFileDTO.class);
    }

    public Stream<TestFile> getAllFiles() {
        return fileRepo.findAll().stream();
    }
}
