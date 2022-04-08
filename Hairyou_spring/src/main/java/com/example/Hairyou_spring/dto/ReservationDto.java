package com.example.Hairyou_spring.dto;

import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long idx;

    private Long customerIdentification; // identification
    private String customerId; // id
    private Long shopId;
    private String shopName;
    private LocalDateTime reservedAt; // 방문할 일시
    private LocalDateTime createdAt;  // 예약 당시 일시
    private String curCondition;
    private String detail;
}
