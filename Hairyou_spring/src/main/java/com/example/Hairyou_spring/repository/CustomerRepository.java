package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
