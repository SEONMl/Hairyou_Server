package com.example.Hairyou_spring.entity;

import com.example.Hairyou_spring.dto.CustomerDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identification;

    @Column(name ="c_id", unique = true)
    private String id;

    private String password;
    private String name;
    private String phone;
    private String gender;

    @Builder
    public CustomerEntity(String id, String password, String name, String phone, String gender) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public void patch(CustomerDto dto){
        if(this.identification != dto.getIdentification())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 있습니다");

        if(dto.getId() != null)
            this.id=dto.getId();
        if(dto.getPassword() != null)
            this.password=dto.getPassword();
        if(dto.getName() != null)
            this.name=dto.getName();
        if(dto.getPhone() != null)
            this.phone=dto.getPhone();
        if(dto.getGender() != null)
            this.gender=dto.getGender();
    }
}

/*
JSON requestBody

{
  "name":"홍길동",
  "gender":"male",
  "id":"test",
  "password":"123asd",
  "phone":"01033331111"
}
 */