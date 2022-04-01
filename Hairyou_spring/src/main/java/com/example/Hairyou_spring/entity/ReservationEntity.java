package com.example.Hairyou_spring.entity;

import com.example.Hairyou_spring.dto.CustomerDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Table(name="reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private CustomerEntity customerId;

    @ManyToOne
    @JoinColumn(name="shop_id")
    private ShopEntity shopId;

    @Column(name="reserved_at", updatable = false)
    private String reservedAt;

    @Column(name = "cur_condition")
    private String curCondition;
    private String detail;

    @Builder
    public ReservationEntity(CustomerEntity customerId, ShopEntity shopId, String reservedAt, String curCondition, String detail) {
        this.customerId = customerId;
        this.shopId = shopId;
        this.reservedAt = reservedAt;
        this.curCondition = curCondition;
        this.detail = detail;
    }
}
