package com.example.Hairyou_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
    private Long id;
    private String shopName;
    private String info;
    private String address; // 주소
    private double latitude; // 위도
    private double longitude; // 경도

}
