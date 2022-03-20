package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;


}
