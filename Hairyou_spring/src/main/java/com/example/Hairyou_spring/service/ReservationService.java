package com.example.Hairyou_spring.service;

import com.example.Hairyou_spring.dto.ReservationDto;
import com.example.Hairyou_spring.entity.CustomerEntity;
import com.example.Hairyou_spring.entity.ReservationEntity;
import com.example.Hairyou_spring.entity.ShopEntity;
import com.example.Hairyou_spring.repository.CustomerRepository;
import com.example.Hairyou_spring.repository.DesignerRepository;
import com.example.Hairyou_spring.repository.ReservationRepository;
import com.example.Hairyou_spring.repository.ShopRepository;
import com.sun.xml.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public ReservationEntity create(ReservationDto dto) {
        CustomerEntity targetCustomer = customerRepository.findByCId(dto.getCustomerId());
        ShopEntity targetShop = shopRepository.findByName(dto.getShopName());

        ReservationEntity created = ReservationEntity.builder()
                .customerId(targetCustomer)
                .curCondition(dto.getCurCondition())
                .detail(dto.getDetail())
                .reservedAt(dto.getReservedAt())
                .shopId(targetShop)
                .build();

        ReservationEntity result = reservationRepository.save(created);
        return result;
    }

    public List<ReservationEntity> findAllReser() {
        return reservationRepository.findAll();
    }

    public List<ReservationEntity> findByShopName(String shopName) {
        // shop_name으로 조회 요청 -> 샵 기본키 조회-> findById
        ShopEntity shopEntity = shopRepository.findByName(shopName);
        log.info(shopEntity.getShopName() + " 미용실 예약 조회, 기본키 : " + shopEntity.getId());

        Long targetId = shopEntity.getId();

        return reservationRepository.findByShopId(targetId);
    }

    public List<ReservationEntity> findByCustomerId(String cId) {
        CustomerEntity customerEntity = customerRepository.findByCId(cId);
        log.info(customerEntity.getInfo() + " 고객 예약 조회, 기본키 : " + customerEntity.getIdentification());

        Long targetId = customerEntity.getIdentification();

        return reservationRepository.findByCustomerId(targetId);
    }

    public void deleteById(Long idx) {
        ReservationEntity target = reservationRepository.findById(idx)
                .orElse(null);
        if (target != null) {
            CustomerEntity booker = target.getCustomerId();
            ShopEntity reservedShop = target.getShopId();
            log.info(booker.getInfo()+ " 예약 취소 | 미용실 : " + reservedShop.getShopName());
        }

        reservationRepository.deleteById(idx);
    }
}
