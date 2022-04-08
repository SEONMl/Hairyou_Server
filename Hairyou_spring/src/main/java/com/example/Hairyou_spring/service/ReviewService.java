package com.example.Hairyou_spring.service;

import com.example.Hairyou_spring.dto.ReviewDto;
import com.example.Hairyou_spring.entity.CustomerEntity;
import com.example.Hairyou_spring.entity.ReviewEntity;
import com.example.Hairyou_spring.entity.ShopEntity;
import com.example.Hairyou_spring.repository.CustomerRepository;
import com.example.Hairyou_spring.repository.DesignerRepository;
import com.example.Hairyou_spring.repository.ReviewRepository;
import com.example.Hairyou_spring.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        ShopEntity targetShop = shopRepository.findByName(dto.getShopName());
        CustomerEntity targetCustomer=customerRepository.findByCId(dto.getCustomerId());

        ReviewEntity created = ReviewEntity.builder()
                .content(dto.getContent())
                .customerId(targetCustomer)
                .shopId(targetShop)
                .build();

        ReviewEntity result = reviewRepository.save(created);
        return result;
    }


    // 전체 리뷰 조회
    public List<ReviewEntity> findAllReviews() {
        return reviewRepository.findAll();
    }

    // 고객 아이디로 리뷰 조회
    public List<ReviewEntity> findAllReviewsByCId(String c_id) {
        CustomerEntity customerEntity = customerRepository.findByCId(c_id);
        Long targetIdentification = customerEntity.getIdentification();
        log.info(customerEntity.getInfo() + " 모든 리뷰 조회, 기본키 : ", targetIdentification);

        return reviewRepository.findAllByCIdentification(targetIdentification);
    }

    public List<ReviewEntity> findAllReviewsByShopName(String shop_name) {
        ShopEntity shopEntity = shopRepository.findByName(shop_name);
        Long targetId = shopEntity.getId();
        log.info(shopEntity.getShopName() +" 미용실 모든 리뷰 조회");

        return reviewRepository.findAllByShopName(targetId);
    }

    public ReviewEntity deleteById(Long idx) {
        ReviewEntity target;
        target = reviewRepository.findById(idx)
                .orElse(null);

        if( target != null) {
           ShopEntity shop = target.getShopId();
           CustomerEntity customer = target.getCustomerId();

           log.info(customer.getInfo()+"의 리뷰 삭제 | 미용실 : " + shop.getShopName());

       }
        reviewRepository.deleteById(idx);
       return target;
    }
}
