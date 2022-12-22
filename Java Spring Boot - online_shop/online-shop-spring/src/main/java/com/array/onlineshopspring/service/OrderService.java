package com.array.onlineshopspring.service;

import com.array.onlineshopspring.dto.UserOrderDTO;

import java.util.List;

public interface OrderService {

    UserOrderDTO addOrder(UserOrderDTO orderDTO, Integer userId);
    List<UserOrderDTO> getAllOrders();
    List<UserOrderDTO> getOrdersByUserId(Integer userId);
    UserOrderDTO getOrderById(Integer orderId);
    UserOrderDTO updateOrder(UserOrderDTO orderDTO, Integer orderId);
    void deleteOrder(Integer orderId);
}
