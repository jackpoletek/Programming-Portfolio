package com.array.onlineshopspring.TestFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestFileDTO {

    private Integer fileId;
    private String fileName;
    private String fileType;
    private byte[] data;
}
