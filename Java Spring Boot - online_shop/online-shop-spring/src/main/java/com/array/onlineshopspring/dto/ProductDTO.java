package com.array.onlineshopspring.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private Integer productId;
    private String productDescription;
    private String species;
    private int stock;
    private BigDecimal price;

    @JsonBackReference
    private CategoryDTO category;

    @JsonManagedReference
    private List<ImageDTO> imageList;
}
