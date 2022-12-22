package com.array.onlineshopspring.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {

    private String imageName;
    private String downloadURL;
    private String imageType;
    private long fileSize;
}
