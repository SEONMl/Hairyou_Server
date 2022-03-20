package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.CustomerEntity;
import com.example.Hairyou_spring.entity.DesignerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DesignerRepository extends JpaRepository<DesignerEntity, Long> {

    @Query(value = "select * from designer where name=: name", nativeQuery = true)
    DesignerEntity findByName(String name);

}
