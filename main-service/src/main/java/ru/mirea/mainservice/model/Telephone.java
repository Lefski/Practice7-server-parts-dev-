package ru.mirea.mainservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "telephones")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creator")
    private String creator;

    @Column(name = "battery_volume")
    private Integer batteryVolume;

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "name")
    private String name;

}
