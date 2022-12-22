package com.array.onlineshopspring.controller;

import com.array.onlineshopspring.dto.OrderItemDTO;
import com.array.onlineshopspring.payload.ApiResponse;
import com.array.onlineshopspring.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200/")
@RequestMapping(value = "/api/v1/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @ResponseBody
    @PostMapping(value = "/new-item", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderItemDTO> addOrderItem(@RequestBody OrderItemDTO itemDTO, Integer prodId, Integer orderId) {
        OrderItemDTO newOrderItem = orderItemService.addOrderItem(itemDTO, prodId, orderId);
        return new ResponseEntity<>(newOrderItem, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all-items")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        List<OrderItemDTO> orderItems = orderItemService.getAllOrderItems();
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

    @GetMapping(value = "/by-id/{itemId}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable("itemId") Integer itemId) {
        OrderItemDTO orderItem = orderItemService.getOrderItemById(itemId);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

    @GetMapping(value = "/by-product/{productId}")
    public ResponseEntity<List<OrderItemDTO>> getOrderItemsByProductId(@PathVariable("productId") Integer productId) {
        List<OrderItemDTO> orderItems = orderItemService.getOrderItemsByProductId(productId);
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{itemId}")
    public ResponseEntity<OrderItemDTO> updateOrderItem(@PathVariable("itemId") Integer itemId, @RequestBody OrderItemDTO item) {
        OrderItemDTO updatedItem = orderItemService.updateOrderItem(item, itemId);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{itemId}")
    public ResponseEntity<ApiResponse> deleteOrderItem(@PathVariable("itemId") Integer itemId) {
        orderItemService.deleteOrderItem(itemId);
        return new ResponseEntity<>(new ApiResponse("Order Item deleted successfully", true), HttpStatus.OK);
    }
}
