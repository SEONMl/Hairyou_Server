package com.example.Hairyou_spring.sevice;

import com.example.Hairyou_spring.dto.CustomerDto;
import com.example.Hairyou_spring.dto.DesignerDto;
import com.example.Hairyou_spring.entity.CustomerEntity;
import com.example.Hairyou_spring.entity.DesignerEntity;
import com.example.Hairyou_spring.repository.CustomerRepository;
import com.example.Hairyou_spring.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DesignerRepository designerRepository;

    // 고객 회원 정보 저장
    public CustomerEntity create(CustomerDto dto) {

        // dto -> entity 변환
        CustomerEntity created = CustomerEntity.builder()
                .id(dto.getId())
                .gender(dto.getGender())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .name(dto.getName())
                .build();

        // entity repository에 저장
        CustomerEntity result = customerRepository.save(created);

        return result;
    }

    // 디자이너 회원 정보 저장
    public DesignerEntity create(DesignerDto dto) {

        // dto -> entity 변환
        DesignerEntity created = DesignerEntity.builder()
                .id(dto.getId())
                .gender(dto.getGender())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .name(dto.getName())
                .build();

        // entity repository에 저장
        DesignerEntity result = designerRepository.save(created);

        return result;
    }

    @Transactional
    public CustomerEntity update(Long identification, CustomerDto customerDto) {
        // 대상 찾기
        CustomerEntity target = customerRepository.findById(identification)
                .orElse(null);

        // 수정용 엔티티 생성
        target.patch(customerDto);
        CustomerEntity updated = customerRepository.save(target);

        return updated;
    }
}
