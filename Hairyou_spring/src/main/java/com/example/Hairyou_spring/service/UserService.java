package com.example.Hairyou_spring.service;

import com.example.Hairyou_spring.dto.CustomerDto;
import com.example.Hairyou_spring.dto.DesignerDto;
import com.example.Hairyou_spring.entity.CustomerEntity;
import com.example.Hairyou_spring.entity.DesignerEntity;
import com.example.Hairyou_spring.entity.ShopEntity;
import com.example.Hairyou_spring.repository.CustomerRepository;
import com.example.Hairyou_spring.repository.DesignerRepository;
import com.example.Hairyou_spring.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DesignerRepository designerRepository;
    @Autowired
    ShopRepository shopRepository;

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
        ShopEntity targetShop = shopRepository.findByName(dto.getShopName());

        // dto -> entity 변환
        DesignerEntity created = DesignerEntity.builder()
                .id(dto.getId())
                .gender(dto.getGender())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .name(dto.getName())
                .shopId(targetShop)
                .build();

        // entity repository에 저장
        DesignerEntity result = designerRepository.save(created);

        return result;
    }

    @Transactional
    public CustomerEntity update(Long identification, CustomerDto customerDto) {
        log.trace("CustomerEntity update 실행");
        // 대상 찾기
        CustomerEntity target = customerRepository.findById(identification).orElse(null);

        // 수정용 엔티티 생성
        target.patch(customerDto);
        CustomerEntity updated = customerRepository.save(target);

        return updated;
    }

    @Transactional
    public CustomerEntity deleteCustomerAccount(String id) {
        // 조회
        log.info(id + " 님 계정 삭제");
        CustomerEntity target = customerRepository.findByCId(id);
        if (target == null) return null;

        // 삭제
        customerRepository.delete(target);

        // 반환
        return target;
    }

    @Transactional
    public DesignerEntity deleteDesignerAccount(String identification) {
        // 조회
        log.trace("디자이너 계정 삭제 : 조회");
        DesignerEntity target = designerRepository.findByDId(identification);

        if (target == null) return null;

        // 삭제
        designerRepository.delete(target);

        // 반환
        return target;
    }

    public List<CustomerEntity> findAllCustomer() {
        return customerRepository.findAll();
    }

    public List<DesignerEntity> findAllDesigner() {
        return designerRepository.findAll();
    }

    public Optional<CustomerEntity> findCustomerByIdentification(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<DesignerEntity> findDesignerByIdentification(Long id) {
        return designerRepository.findById(id);
    }

    public CustomerEntity findCustomerById(String id) {
        return customerRepository.findByCId(id);
    }

    public DesignerEntity findDesignerById(String id) {
        return designerRepository.findByDId(id);
    }
}
