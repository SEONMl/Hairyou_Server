package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.dto.CustomerDto;
import com.example.Hairyou_spring.dto.DesignerDto;
import com.example.Hairyou_spring.entity.CustomerEntity;
import com.example.Hairyou_spring.entity.DesignerEntity;
import com.example.Hairyou_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserService userService;


    // 전체 고객 계정 조회
    @GetMapping("/account/customers") // 200
    public List<CustomerEntity> findAllCustomer(){
        return userService.findAllCustomer();
    }

    // 전체 디자이너 계정 조회
    @GetMapping("/account/designers") // 200
    public List<DesignerEntity> findAllDesigner() {
        return userService.findAllDesigner();
    }

    // 고객 identification으로 계정 조회
    @GetMapping("/account/customer/{identification}") // 200
    public Optional<CustomerEntity> findCustomerById(@PathVariable Long identification){
        return userService.findCustomerByIdentification(identification);
    }

    // 디자이너 identification으로 계정 조회
    @GetMapping("/account/designer/{identification}") // 200
    public Optional<DesignerEntity> findDesignerById(@PathVariable Long identification){
        return userService.findDesignerByIdentification(identification);
    }

    // 고객 아이디로 고객 계정 조회
    @GetMapping("/account/customer/id/{id}") // 200
    public CustomerEntity findCustomerByCId(@PathVariable String id){
        return userService.findCustomerById(id);
    }

    // 디자이너 아이디로 계정 조회
    @GetMapping("/account/designer/id/{id}") // test
    public DesignerEntity findDesignerByDId(@PathVariable String id) {return userService.findDesignerById(id); }



    // 고객 계정 추가
    @PostMapping("/account/customer") // 200
    public ResponseEntity<CustomerEntity> save(@RequestBody CustomerDto customerDto){

        CustomerEntity saved = userService.create(customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    // 디자이너 계정 추가
    @PostMapping("/account/designer") // 200
    public ResponseEntity<DesignerEntity> save(@RequestBody DesignerDto designerDto) {

        DesignerEntity saved = userService.create(designerDto);

        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }


    // 고객 회원정보 수정 | identification으로 조회
    @PutMapping("/account/customer/{identification}") // 500
    public ResponseEntity<CustomerEntity> update(@PathVariable Long identification,
                                                 @RequestBody CustomerDto customerDto){

        CustomerEntity updated = userService.update(identification, customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // 디자이너 회원정보 수정



    // 고객 계정 삭제
    @DeleteMapping("/account/customer/id/{id}") // 200
    public ResponseEntity<CustomerEntity> deleteC(@PathVariable String id){
        CustomerEntity deleted = userService.deleteCustomerAccount(id);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

    // 디자이너 계정 삭제
    @DeleteMapping("/account/designer/id/{id}") // 200
    public ResponseEntity<DesignerEntity> deleteD(@PathVariable String id){
        DesignerEntity deleted = userService.deleteDesignerAccount(id);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}

