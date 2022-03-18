package com.example.Hairyou_spring.entity;

import com.example.Hairyou_spring.dto.CustomerDto;
import lombok.Builder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private CustomerEntity cId;

    @ManyToOne
    @JoinColumn(name="shop_name")
    private ShopEntity shopName;

    @Column(name="reserved_at")
    private String reservedAt;

    @Column(name = "cur_condition")
    private String curCondition;
    private String detail;

    @Builder
    public ReservationEntity(CustomerEntity cId, ShopEntity shopName, String reservedAt, String curCondition, String detail) {
        this.cId = cId;
        this.shopName = shopName;
        this.reservedAt = reservedAt;
        this.curCondition = curCondition;
        this.detail = detail;
    }
}
