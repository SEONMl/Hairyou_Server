package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    // 외래키 shop_id로 조회
    @Query(value = "select * from reservation where shop_id=:shopId", nativeQuery = true)
    List<ReservationEntity> findByShopId(Long shopId);

    // 외래키 customer_id로 조회
    @Query(value = "select * from reservation where c_id=:cId", nativeQuery = true)
    List<ReservationEntity> findByCustomerIdentification(Long cId);

}
