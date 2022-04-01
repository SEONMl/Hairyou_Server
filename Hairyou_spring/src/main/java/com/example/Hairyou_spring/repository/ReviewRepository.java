package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Query(value = "select * from review where c_id=:c_identification", nativeQuery = true)
    List<ReviewEntity> findAllByCIdentification(Long c_identification);

    @Query(value = "select * from review where shop_id=:targetId", nativeQuery = true)
    List<ReviewEntity> findAllByShopName(Long targetId);
}
