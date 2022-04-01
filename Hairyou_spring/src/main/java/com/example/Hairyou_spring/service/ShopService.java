package com.example.Hairyou_spring.service;

import com.example.Hairyou_spring.dto.ShopDto;
import com.example.Hairyou_spring.entity.ShopEntity;
import com.example.Hairyou_spring.repository.DesignerRepository;
import com.example.Hairyou_spring.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private DesignerRepository designerRepository;


    public List<ShopEntity> findAllShop() {
        List<ShopEntity> targets = shopRepository.findAll();
        return targets;
    }

    // 미용실 저장
    public ShopEntity saveShop(ShopDto dto) {

        ShopEntity created = ShopEntity.builder()
                .shopName(dto.getShopName())
                .info(dto.getInfo())
                .address(dto.getAddress())
                .build();

        // 입력받은 address를 latitude, longitude로 변환 해서 DB에 저장하기
        // 주소

        ShopEntity saved = shopRepository.save(created);

        return saved;
    }


    public ShopEntity findByName(String name) {
        ShopEntity target = shopRepository.findByName(name);
        return target;
    }
}
