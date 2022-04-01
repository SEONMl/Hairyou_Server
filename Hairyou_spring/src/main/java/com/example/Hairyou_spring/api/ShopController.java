package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.dto.ShopDto;
import com.example.Hairyou_spring.entity.ShopEntity;
import com.example.Hairyou_spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;


    // 미용실 조회
    @GetMapping("/shop") // 200
    public List<ShopEntity> findAllShop() {
        return shopService.findAllShop();
    }

    @GetMapping("/shop/{shop_name}")  // 200
    public ShopEntity findShopByName(@PathVariable String shop_name){
        return shopService.findByName(shop_name);
    }


    // 미용실 저장
    @PostMapping("/shop") // 200
    public ResponseEntity<ShopEntity> saveShop(@RequestBody ShopDto dto){
        ShopEntity saved = shopService.saveShop(dto);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }


}
