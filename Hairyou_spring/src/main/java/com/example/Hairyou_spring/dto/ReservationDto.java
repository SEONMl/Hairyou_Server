package com.example.Hairyou_spring.dto;

import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String reservedAt;
    private String curCondition;
    private String detail;
}
