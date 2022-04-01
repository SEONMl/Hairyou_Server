package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.dto.ReservationDto;
import com.example.Hairyou_spring.entity.ReservationEntity;
import com.example.Hairyou_spring.service.ReservationService;
import com.example.Hairyou_spring.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;


    // 모든 예약 조회
    @GetMapping("/reservations") // 200
    public List<ReservationEntity> findAll(){
        return reservationService.findAllReser();
    }

    // 고객 아이디로 예약 조회
    @GetMapping("/account/{id}/reservations") // 200
    public List<ReservationEntity> findByCId(@PathVariable String id) {
        // 고객 id로 예약 조회 (id -> 고객 identification -> c_id 칼럼 조회)
        return reservationService.findByCustomerId(id);
    }

    // 미용실 이름으로 예약 조회
    @GetMapping("/shop/{shop_name}/reservations") // 200
    public List<ReservationEntity> findByShopName(@PathVariable String shop_name){
        //shop name으로 요청 -> 샵 기본키 조회-> findById
        return reservationService.findByShopName(shop_name);
    }


    // 리뷰 저장
    @PostMapping("/reservation") // 200
    public ResponseEntity<ReservationEntity> saveReservation(@RequestBody ReservationDto dto){
        ReservationEntity saved = reservationService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }


    // 예약 삭제
    @DeleteMapping("/reservation/{idx}") // 200
    public void deleteByIdx(@PathVariable Long idx){
       reservationService.deleteById(idx);
       return;
    }

    @DeleteMapping("/shop/{shop_name}/reservation/{index}") // test
    public ResponseEntity<ReservationEntity> deleteByShopNameAndIndex (
            @PathVariable String shop_name,
            @PathVariable Long index
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ReservationEntity());
    }

    @DeleteMapping("/account/{c_id}/reservation/{index}") // test
    public ResponseEntity<ReservationEntity> deleteByCIdAndIndex(
            @PathVariable String c_id,
            @PathVariable Long index
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ReservationEntity());
    }

}
