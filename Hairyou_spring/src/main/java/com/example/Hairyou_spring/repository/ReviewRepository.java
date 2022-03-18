package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
