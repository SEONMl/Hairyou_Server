package com.example.Hairyou_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private int id;
    private int userId;
    private String title;
    private String body;
}
