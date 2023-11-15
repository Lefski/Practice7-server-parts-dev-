package ru.mirea.mainservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cart_item_id")
    private Long cartItemId;

    @Enumerated(EnumType.STRING)
    private ProductType cartItemType;

    @Column(name = "cart_item_name")
    private String cartItemName;

    @Column(name = "cart_items_amount")
    private Integer cartItemsAmount;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;
}
