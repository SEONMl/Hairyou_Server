package com.example.Hairyou_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long identification;
    private String id;
    private String password;
    private String name;
    private String phone;
    private String gender;
}
