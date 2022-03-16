package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne //다(order) 대 일(member)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order") //order 에 의해 맵핑이 됨
    private List<OrderItem> orderItem = new ArrayList<>();

    @OneToOne //일 대 일
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; //주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]



}
