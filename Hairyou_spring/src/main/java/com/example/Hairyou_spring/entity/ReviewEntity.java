package com.example.Hairyou_spring.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shopId;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private CustomerEntity customerId;

    @Column(name = "written_at", updatable = false)
    private String writtenAt;
    private String content;

    @Builder
    public ReviewEntity(ShopEntity shopId, CustomerEntity customerId, String writtenAt, String content) {
        this.customerId = customerId;
        this.shopId = shopId;
        this.writtenAt = writtenAt;
        this.content = content;
    }
}

