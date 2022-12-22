package com.array.onlineshopspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageDTO {

    private Integer imageId;
    private String imageName;
    private String imageType;
    private byte[] imageByte;

    @JsonManagedReference
    private List<ProductDTO> productList;
}
