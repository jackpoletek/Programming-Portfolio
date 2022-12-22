package com.array.onlineshopspring.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemDTO {

    private Integer orderItemId;
    private int quantity;
    private BigDecimal totalPrice;

    @JsonBackReference
    private ProductDTO product;

    @JsonBackReference
    private UserOrderDTO order;
}
