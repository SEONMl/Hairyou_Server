package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.dto.CustomerDto;
import com.example.Hairyou_spring.dto.DesignerDto;
import com.example.Hairyou_spring.entity.CustomerEntity;
import com.example.Hairyou_spring.entity.DesignerEntity;
import com.example.Hairyou_spring.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserService userService;


    // 전체 고객 계정 조회
    @GetMapping("/account/customers")
    public List<CustomerEntity> findAllCustomer(){
        return userService.findAllCustomer();
    }

    // 전체 디자이너 계정 조회
    @GetMapping("/account/designers")
    public List<DesignerEntity> findAllDesigner() {
        return userService.findAllDesigner();
    }

    @GetMapping("/account/customer/{identification}")
    public Optional<CustomerEntity> findCustomerById(@PathVariable Long identification){
        return userService.findCustomerById(identification);
    }

    @GetMapping("/account/designer/{identification}")
    public Optional<DesignerEntity> findDesignerById(@PathVariable Long identification){
        return userService.findDesignerById(identification);
    }


    // 고객 계정 추가
    @PostMapping("/account/customer")
    public ResponseEntity<CustomerEntity> save(@RequestBody CustomerDto customerDto){

        CustomerEntity saved = userService.create(customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    // 디자이너 계정 추가
    @PostMapping("/account/designer")
    public ResponseEntity<DesignerEntity> save(@RequestBody DesignerDto designerDto) {

        DesignerEntity saved = userService.create(designerDto);

        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    // 고객 회원정보 수정 | identification으로 조회
    @PutMapping("/account/customer/{identification}") // 500에러
    public ResponseEntity<CustomerEntity> update(@PathVariable Long identification,
                                                 @RequestBody CustomerDto customerDto){

        CustomerEntity updated = userService.update(identification, customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // 디자이너 회원정보 수정

    // 고객 계정 삭제
    @DeleteMapping("/account/customer/{identification}")
    public ResponseEntity<CustomerEntity> deleteC(@PathVariable Long identification){
        CustomerEntity deleted = userService.deleteCustomerAccount(identification);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

    // 디자이너 계정 삭제
    @DeleteMapping("/account/designer/{identification}")
    public ResponseEntity<DesignerEntity> deleteD(@PathVariable Long identification){
        DesignerEntity deleted = userService.deleteDesignerAccount(identification);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}

