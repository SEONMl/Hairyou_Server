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
    private Long index;
    private Long cId;
    private String shopName;
    private Date reservedAt;
    private String curCondition;
    private String detail;
}
