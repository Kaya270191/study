package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id; //id

    private String name; //회원명

    @Embedded //내장타입
    private Address address; //주소

    @OneToMany(mappedBy = "member") //일(Member) 대 다(order)
    private List<Order> orders = new ArrayList<>(); //주문
}
