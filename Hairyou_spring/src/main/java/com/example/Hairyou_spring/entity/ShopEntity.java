package com.example.Hairyou_spring.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@NoArgsConstructor
@Table(name="shop")
public class ShopEntity {
    @Id
    @Column(name="shop_name")
    private String shopName;
    private String info;
    private String treatment;

    @Builder
    public ShopEntity(String shop_name, String info, String treatment) {
        this.shopName = shop_name;
        this.info = info;
        this.treatment = treatment;
    }
}
