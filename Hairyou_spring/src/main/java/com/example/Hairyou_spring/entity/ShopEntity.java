package com.example.Hairyou_spring.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
@Table(name="shop")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="shop_name")
    private String shopName;
    private String info;
    private String treatment;

    @Builder
    public ShopEntity(String shopName, String info, String treatment) {
        this.shopName = shopName;
        this.info = info;
        this.treatment = treatment;
    }
}
