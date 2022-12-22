package com.array.onlineshopspring.model;

import com.array.onlineshopspring.constants.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_order")
public class UserOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    @NotNull
    private Integer orderId;
	
    @Column(name = "date_added")
    private LocalDateTime dateAdded;
	
    @Column(name = "total")
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

//    private boolean isPaid; // todo: depends on Order Status;

    public void getTotalAmount(List<OrderItem> orderItems) {
        BigDecimal total = new BigDecimal("0");

        for(OrderItem item: orderItems){
            BigDecimal itemPrice = item.getTotalPrice();
            total = total.add(itemPrice);
        }
        setTotal(total);
    }
}
