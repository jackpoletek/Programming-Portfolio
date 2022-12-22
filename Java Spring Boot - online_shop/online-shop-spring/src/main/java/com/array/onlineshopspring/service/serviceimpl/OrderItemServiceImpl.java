package com.array.onlineshopspring.service.serviceimpl;

import com.array.onlineshopspring.dto.OrderItemDTO;
import com.array.onlineshopspring.exception.ResourceNotFoundException;
import com.array.onlineshopspring.model.OrderItem;
import com.array.onlineshopspring.model.Product;
import com.array.onlineshopspring.model.UserOrder;
import com.array.onlineshopspring.repository.OrderItemRepository;
import com.array.onlineshopspring.repository.OrderRepository;
import com.array.onlineshopspring.repository.ProductRepository;
import com.array.onlineshopspring.service.OrderItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderRepository orderRepository,
                                ProductRepository productRepository, ModelMapper modelMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public OrderItemDTO addOrderItem(OrderItemDTO itemDTO, Integer prodId, Integer orderId) {

        // If OrderItem ID is not null
        OrderItem item = Optional.ofNullable(itemDTO.getOrderItemId())
                .flatMap(orderItemRepository::findById)
                .orElse(null);

        Product product = productRepository.findById(prodId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", prodId));

        UserOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

        if (item == null) {
            item = new OrderItem();

            item.setProduct(product);
            mapStockAndQuantity(item);
            item.setOrder(order);
            item.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));

            orderItemRepository.save(item);
        } else {
            // OrderItem already present -> UserOrders is present, too
            item.setProduct(product);
            mapStockAndQuantity(item);
            item.setTotalPrice(itemDTO.getTotalPrice().add(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))));
        }

        return modelMapper.map(item, OrderItemDTO.class);
    }

    @Override
    public List<OrderItemDTO> getAllOrderItems() {
        List<OrderItem> allOrderItems = orderItemRepository.findAll();

        List<OrderItemDTO> orderItems = allOrderItems.stream()
                .map(it -> modelMapper.map(it, OrderItemDTO.class)).toList();

        return orderItems;
    }

    @Override
    public OrderItemDTO getOrderItemById(Integer orderItemId) {
        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(()-> new ResourceNotFoundException("OrderItem", "id", orderItemId));

        return modelMapper.map(orderItem, OrderItemDTO.class);
    }

    @Override
    public List<OrderItemDTO> getOrderItemsByProductId(Integer productId) {
        List<OrderItem> orderItems = orderItemRepository.findAll();

        List<OrderItemDTO> itemsByProduct = orderItems.stream()
                .filter(it -> Objects.equals(it.getProduct().getProductId(), productId))
                .map(it -> modelMapper.map(it, OrderItemDTO.class))
                .toList();

        return itemsByProduct;
    }

    @Override
    public OrderItemDTO updateOrderItem(OrderItemDTO itemDTO, Integer orderItemId) {

        OrderItem item = Optional.ofNullable(itemDTO.getOrderItemId())
                .flatMap(orderItemRepository::findById)
                .orElse(null);

        Product product = Optional.ofNullable(itemDTO.getProduct().getProductId())
                .flatMap(productRepository::findById)
                .orElse(null);

        if (item == null) {
            System.out.println("No item found");
            throw new ResourceNotFoundException("Order item", "id", orderItemId);
        }

        item.setProduct(product);
        mapStockAndQuantity(item);

        if (product != null) {
            item.setTotalPrice(itemDTO.getTotalPrice().add(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))));
        } else {
            System.out.println("No products found in your order");
        }

        OrderItem updatedItem = orderItemRepository.save(item);

        return modelMapper.map(updatedItem, OrderItemDTO.class);
    }

    @Override
    public void deleteOrderItem(Integer orderItemId) {
        //todo Set Product STOCK to previous state
        // If Order Completed -> leave stock as is

        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(()-> new ResourceNotFoundException("OrderItem", "id", orderItemId));

        setStockQuantityOnDel(orderItem);

        orderItemRepository.delete(orderItem);
    }

    private void setStockQuantityOnDel(OrderItem orderItem) {
        Product product = orderItem.getProduct();

        product.setStock(product.getStock() + orderItem.getQuantity());
        orderItem.setQuantity(0);
    }
	
    private void mapStockAndQuantity(OrderItem orderItem) {

        Product product = orderItem.getProduct();
        int currentStock = product.getStock();

        int quantity = orderItem.getQuantity();
        int quantityRequested = 0;

        if (currentStock <= 0) {
            System.out.println("Sorry, we're out of stock.");
            orderItem.setQuantity(0);
        }

        else if (quantity >= currentStock) {
            // Set quantity to max stock available
            quantityRequested = currentStock;
            System.out.println("Maximum stock");
            product.setStock(0); //currentStock - quantity
            orderItem.setQuantity(quantityRequested);

        } else {
            quantityRequested = quantity;
        }

        product.setStock(product.getStock() - quantityRequested);
        orderItem.setQuantity(quantityRequested);
    }

    private void mapPriceAndQuantity(OrderItem orderItem) {
        Product product = orderItem.getProduct();
        orderItem.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
    }

    private void saveProduct(OrderItem item) {
        List<Product> productList = productRepository.findAll();

        Product product = (Product) productList.stream()
                .filter(it -> Objects.equals(it.getProductId(), item.getProduct().getProductId()));

        item.setProduct(product);
    }
	
    private void saveOrder(OrderItem item) {
        List<UserOrder> orderList = orderRepository.findAll();

        UserOrder order = (UserOrder) orderList.stream()
                .filter(it -> Objects.equals(it.getOrderId(), item.getOrder().getOrderId()));

        item.setOrder(order);
    }
	
    private Product matchProduct(OrderItem item) {
        List<Product> productList = productRepository.findAll();

        Product product = productList.stream()
                .filter(it -> Objects.equals(it.getProductId(), item.getProduct().getProductId()))
                .map(Product.class::cast)
                .findFirst()
                .orElse(null);

        return product;
    }
	
    private UserOrder matchOrder(OrderItem item) {
        List<UserOrder> orderList = orderRepository.findAll();

        UserOrder order = orderList.stream()
                .filter(it -> Objects.equals(it.getOrderId(), item.getOrder().getOrderId()))
                .map(UserOrder.class::cast)
                .findFirst()
                .orElse(null);

        return order;
    }
}
