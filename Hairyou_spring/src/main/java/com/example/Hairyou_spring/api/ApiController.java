package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.dto.CustomerDto;
import com.example.Hairyou_spring.dto.DesignerDto;
import com.example.Hairyou_spring.entity.CustomerEntity;
import com.example.Hairyou_spring.entity.DesignerEntity;
import com.example.Hairyou_spring.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    private UserService userService;


    @PostMapping("/account/customer")
    public ResponseEntity<CustomerEntity> save(@RequestBody CustomerDto customerDto){

        CustomerEntity saved = userService.create(customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    @PostMapping("/account/designer")
    public ResponseEntity<DesignerEntity> save(@RequestBody DesignerDto designerDto) {

        DesignerEntity saved = userService.create(designerDto);

        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    @PatchMapping("/account/customer/{identification}") // 500에러
    public ResponseEntity<CustomerEntity> update(@PathVariable Long identification,
                                                 @RequestBody CustomerDto customerDto){

        CustomerEntity updated = userService.update(identification, customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}

