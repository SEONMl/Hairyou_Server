package com.example.Hairyou_spring.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @JoinColumn(name = "shop_name")
    private ShopEntity shopName;

    @Column(name = "writed_at")
    private String writedAt;
    private String content;

    @Builder
    public ReviewEntity(ShopEntity shop_name, String writed_at, String content) {
        this.shopName = shop_name;
        this.writedAt = writed_at;
        this.content = content;
    }
}

