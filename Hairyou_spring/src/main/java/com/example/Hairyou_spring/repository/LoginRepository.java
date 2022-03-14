package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, String> {

}
