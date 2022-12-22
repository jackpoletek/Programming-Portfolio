package com.array.onlineshopspring.controller;

import com.array.onlineshopspring.dto.UserOrderDTO;
import com.array.onlineshopspring.payload.ApiResponse;
import com.array.onlineshopspring.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200/")
@RequestMapping(value = "/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @PostMapping(value = "/new-order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserOrderDTO> addOrder(@RequestBody UserOrderDTO orderDTO, Integer userId) {
         UserOrderDTO newOrder = orderService.addOrder(orderDTO, userId);
         return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all-orders")
    public ResponseEntity<List<UserOrderDTO>> getOrders() {
        List<UserOrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/by-id/{orderId}")
    public ResponseEntity<UserOrderDTO> getOrderById(@PathVariable("orderId") Integer orderId) {
        UserOrderDTO order = orderService.getOrderById(orderId);
        if (order == null) {
            System.out.println("No items present in your order");
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/by-order/{orderId}")
    public ResponseEntity<List<UserOrderDTO>> getOrdersByUser(@PathVariable("userId") Integer orderId) {
        List<UserOrderDTO> orders = orderService.getOrdersByUserId(orderId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{orderId}")
    public ResponseEntity<UserOrderDTO> updateOrder(@PathVariable("orderId") Integer orderId, @Valid @RequestBody UserOrderDTO order) {
        UserOrderDTO updatedOrder = orderService.updateOrder(order, orderId);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{orderId}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable("orderId") Integer orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(new ApiResponse("Order deleted successfully", true), HttpStatus.OK);
    }
}
