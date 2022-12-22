package com.array.onlineshopspring;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderTest {

    private Integer orderId;
    private LocalDateTime addDate;
    private boolean paid;
    private String paymentMethod;
}
