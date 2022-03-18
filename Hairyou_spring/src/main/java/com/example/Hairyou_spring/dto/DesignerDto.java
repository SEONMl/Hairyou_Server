package com.example.Hairyou_spring.dto;

import com.example.Hairyou_spring.entity.ShopEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DesignerDto {
    private Long identification;

    private String id;
    private String password;
    private String name;
    private String phone;
    private String gender;

    private String shopName;
}
