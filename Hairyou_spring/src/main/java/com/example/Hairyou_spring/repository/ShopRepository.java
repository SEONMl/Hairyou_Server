package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    @Query(value = "select * from shop where shop_name = :name", nativeQuery = true)
    ShopEntity findByName(String name);
}
