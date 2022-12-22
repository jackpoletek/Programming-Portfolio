package com.array.onlineshopspring.service.serviceimpl;

import com.array.onlineshopspring.constants.OrderStatus;
import com.array.onlineshopspring.dto.UserOrderDTO;
import com.array.onlineshopspring.exception.ResourceNotFoundException;
import com.array.onlineshopspring.model.AppUser;
import com.array.onlineshopspring.model.OrderItem;
import com.array.onlineshopspring.model.UserOrder;
import com.array.onlineshopspring.repository.OrderItemRepository;
import com.array.onlineshopspring.repository.OrderRepository;
import com.array.onlineshopspring.repository.UserRepository;
import com.array.onlineshopspring.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
	
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository,
                            OrderItemRepository itemRepository, ModelMapper modelMapper) {
								
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserOrderDTO addOrder(UserOrderDTO orderDTO, Integer userId) {

        // If id is not null
        UserOrder order = Optional.ofNullable(orderDTO.getOrderId())
                .flatMap(orderRepository::findById)
                .orElse(null);

        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        if (order == null) {
            order = new UserOrder();
        }
        // UserOrder is added when creating new OrderItem

        LocalDateTime dateTime = LocalDateTime.now();

        order.setUser(user);
        setTotalAmount(order);
        order.setDateAdded(dateTime);
        order.setOrderStatus(OrderStatus.created);

        orderRepository.save(order);
        order.setOrderStatus(OrderStatus.completed);

        UserOrder newOrder = orderRepository.save(order);

        return modelMapper.map(newOrder, UserOrderDTO.class);
    }
	
    @Override
    public List<UserOrderDTO> getAllOrders() {
        List<UserOrder> allOrders = orderRepository.findAll();

        List<UserOrderDTO> orders = allOrders.stream()
                .map(it -> modelMapper.map(it, UserOrderDTO.class)).toList();

        return orders;
    }

    @Override
    public UserOrderDTO getOrderById(Integer orderId) {
         UserOrder order = orderRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Order", "id", orderId));

        return modelMapper.map(order, UserOrderDTO.class);
    }

    @Override
    public List<UserOrderDTO> getOrdersByUserId(Integer userId) {

        List<UserOrder> orders = orderRepository.findAll();

        List<UserOrderDTO> userOrders = orders.stream()
                .filter(it -> Objects.equals(it.getUser().getUserId(), userId))
                .map(it -> modelMapper.map(it, UserOrderDTO.class))
                .toList();

        return userOrders;
    }

    @Override
    public UserOrderDTO updateOrder(UserOrderDTO orderDTO, Integer orderId) {

        UserOrder order = Optional.ofNullable(orderDTO.getOrderId())
                .flatMap(orderRepository::findById)
                .orElse(null);

        UserOrder updatedOrder = new UserOrder();

        if (order != null) {
            setTotalAmount(order);
            updatedOrder = orderRepository.save(order);
        } else {
            System.out.println("No order found");
        }

        return modelMapper.map(updatedOrder, UserOrderDTO.class);
    }

    @Override
    public void deleteOrder(Integer orderId) {

        UserOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

        order.setOrderStatus(OrderStatus.cancelled);

        orderRepository.delete(order);
    }

    private void setTotalAmount(UserOrder order) {
        BigDecimal total = new BigDecimal("0");

        List<OrderItem> items = order.getOrderItems();

        for(OrderItem item: items){
            BigDecimal itemPrice = item.getTotalPrice();
            total = total.add(itemPrice);
        }
        order.setTotal(total);
    }

    private void saveUser(UserOrder order) {
        List<AppUser> userList = userRepository.findAll();

        AppUser user = userList.stream()
                .filter(it -> Objects.equals(it.getUserId(), order.getUser().getUserId()))
                .map(AppUser.class::cast)
                .findFirst()
                .orElse(null);

        order.setUser(user);
    }
	
    private AppUser matchUser(UserOrder order) {
        List<AppUser> userList = userRepository.findAll();

        AppUser user = userList.stream()
                .filter(it -> Objects.equals(it.getUserId(), order.getUser().getUserId()))
                .map(AppUser.class::cast)
                .findFirst()
                .orElse(null);

        return user;
    }
}
