package com.example.Hairyou_spring.service;

import com.example.Hairyou_spring.repository.CustomerRepository;
import com.example.Hairyou_spring.repository.DesignerRepository;
import com.example.Hairyou_spring.repository.ReservationRepository;
import com.example.Hairyou_spring.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private DesignerRepository designerRepository;

}
