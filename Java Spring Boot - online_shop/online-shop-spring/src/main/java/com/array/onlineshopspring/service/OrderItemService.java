package com.array.onlineshopspring.service;

import com.array.onlineshopspring.dto.OrderItemDTO;

import java.util.List;

public interface OrderItemService {

    OrderItemDTO addOrderItem(OrderItemDTO itemDTO, Integer prodId, Integer orderId);
    List<OrderItemDTO> getAllOrderItems();
    OrderItemDTO getOrderItemById(Integer orderItemId);
    List<OrderItemDTO> getOrderItemsByProductId(Integer productId);
    OrderItemDTO updateOrderItem(OrderItemDTO orderItem, Integer orderItemId);
    void deleteOrderItem(Integer orderItemId);
}
