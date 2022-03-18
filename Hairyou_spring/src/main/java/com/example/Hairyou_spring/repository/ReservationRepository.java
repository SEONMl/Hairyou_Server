package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
