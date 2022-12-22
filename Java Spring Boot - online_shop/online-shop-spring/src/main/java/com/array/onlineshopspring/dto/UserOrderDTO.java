package com.array.onlineshopspring.dto;

import com.array.onlineshopspring.constants.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserOrderDTO {

    private Integer orderId;
    private LocalDateTime dateAdded;
    private BigDecimal total;
    private OrderStatus orderStatus;

    @JsonManagedReference
    private List<OrderItemDTO> orderItems;

    @JsonBackReference
    private AppUserDTO user;
}
