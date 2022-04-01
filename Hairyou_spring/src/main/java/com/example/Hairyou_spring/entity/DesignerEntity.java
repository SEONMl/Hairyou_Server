package com.example.Hairyou_spring.entity;

import com.sun.istack.NotNull;
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

    @NotNull
    @Column(name = "d_id", unique = true)
    private String id;
    @NotNull
    private String password;
    private String name;
    private String phone;
    private String gender;

    @OneToOne
    @JoinColumn(name="shop_id")
    private ShopEntity shopId;

    @Builder
    public DesignerEntity(String id, String password, String name, String phone, String gender, ShopEntity shopId) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.shopId = shopId;
    }

    public String getInfo() {
        return this.name + "님(" +this.identification+"번 / " +this.id + ")";
    }
}
