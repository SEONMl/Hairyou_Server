package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.dto.ReviewDto;
import com.example.Hairyou_spring.entity.ReviewEntity;
import com.example.Hairyou_spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    // 리뷰 생성
    @PostMapping("/review")
    public ResponseEntity<ReviewEntity> createReview(@RequestBody ReviewDto dto){
        ReviewEntity created = reviewService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }


}
