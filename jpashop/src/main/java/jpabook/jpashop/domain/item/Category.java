package jpabook.jpashop.domain.item;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany // 다 대 다
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
