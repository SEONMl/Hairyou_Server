package com.example.Hairyou_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long idx;
    private Long shopId;
    private String shopName;
    private Long customerIdentification; // identification
    private String customerId; // id

    private LocalDateTime writtenAt;
    private String content;
}
