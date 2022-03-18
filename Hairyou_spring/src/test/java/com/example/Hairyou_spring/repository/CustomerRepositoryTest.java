package com.example.Hairyou_spring.repository;

import com.example.Hairyou_spring.entity.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebAppConfiguration
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void repositoryTest() {

        // 실제 save할 데이터
        CustomerEntity customer = CustomerEntity.builder()
                .gender("female")
                .name("박선미")
                .phone("01011112222")
                .id("qwerrt")
                .password("1234")
                .build();

        CustomerEntity result = customerRepository.save(customer);

        System.out.println(customer.getGender());
        System.out.println(result.getGender());
        assertEquals(customer.getId(), result.getId());
        assertEquals(result.getIdentification(), 1L);

    }
}