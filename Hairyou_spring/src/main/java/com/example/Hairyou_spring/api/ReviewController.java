package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.dto.ReviewDto;
import com.example.Hairyou_spring.entity.ReviewEntity;
import com.example.Hairyou_spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    // 모든 리뷰 조회
    @GetMapping("/reviews") // 200
    public List<ReviewEntity> findAll(){
        return reviewService.findAllReviews();
    }

    // 고객 아이디로 리뷰 조회
    @GetMapping("/account/{c_id}/reviews") // 500
    public List<ReviewEntity> findAllByCId(@PathVariable String c_id){
        return reviewService.findAllReviewsByCId(c_id);
    }

    // 미용실 이름으로 리뷰 조회
    @GetMapping("/shop/{shop_name}/reviews") // test
    public List<ReviewEntity> findAllByShopName(@PathVariable String shop_name){
        return reviewService.findAllReviewsByShopName(shop_name);
    }


    // 리뷰 생성
    @PostMapping("/review") // 200
    public ResponseEntity<ReviewEntity> createReview(@RequestBody ReviewDto dto){
        ReviewEntity created = reviewService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }


    @DeleteMapping("/review/{idx}") // 200
    public ResponseEntity<ReviewEntity> deleteByIndex(@PathVariable Long idx){
        ReviewEntity deleted = reviewService.deleteById(idx);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

    @DeleteMapping("/account/{c_id}/review/{idx}") // test
    public ResponseEntity<ReviewEntity> deleteByCIdAndIndex(
            @PathVariable String c_id,
            @PathVariable Long idx
    ){

        return ResponseEntity.status(HttpStatus.OK).body(new ReviewEntity());
    }





}
