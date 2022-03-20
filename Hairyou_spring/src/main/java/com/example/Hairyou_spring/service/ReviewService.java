package com.example.Hairyou_spring.service;

import com.example.Hairyou_spring.dto.ReviewDto;
import com.example.Hairyou_spring.entity.ReviewEntity;
import com.example.Hairyou_spring.repository.CustomerRepository;
import com.example.Hairyou_spring.repository.DesignerRepository;
import com.example.Hairyou_spring.repository.ReviewRepository;
import com.example.Hairyou_spring.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DesignerRepository designerRepository;
    @Autowired
    private ShopRepository shopRepository;

    public ReviewEntity create(ReviewDto dto) {


        ReviewEntity created = ReviewEntity.builder()
                .content(dto.getContent())
                .shop_name(shopRepository.findByName(dto.getShopName()))
                .build();

        ReviewEntity result = reviewRepository.save(created);
        return result;
    }

    // 리뷰 생성

    // 리뷰 삭제

    // 리뷰 수정

}
