package com.example.Hairyou_spring.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="designer")
public class DesignerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identification;

    @Column( unique = true)
    private String id;

    private String password;
    private String name;
    private String phone;
    private String gender;

    @OneToOne
    @JoinColumn(name="shop_name")
    private ShopEntity shopName;

    @Builder
    public DesignerEntity(String id, String password, String name, String phone, String gender, ShopEntity shop_name) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.shopName = shop_name;
    }
}
