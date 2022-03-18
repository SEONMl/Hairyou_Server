package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, String> {
}
