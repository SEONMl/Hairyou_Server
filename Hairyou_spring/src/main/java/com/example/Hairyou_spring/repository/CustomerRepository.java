package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query(value = "select * from customer where name= :name", nativeQuery = true)
    CustomerEntity findByName(String name);

    @Query(value = "select * from customer where c_id= :cId", nativeQuery = true)
    CustomerEntity findByCId(String cId);
}
