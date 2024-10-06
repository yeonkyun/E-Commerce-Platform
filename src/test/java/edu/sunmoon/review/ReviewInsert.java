package edu.sunmoon.review;

import edu.sunmoon.dto.Review;
import edu.sunmoon.service.ReviewService;

public class ReviewInsert {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        try {
            System.out.println(reviewService.add(Review.builder()
                    .productId(158)
                    .customerId("customer999")
                    .rating(5)
                    .content("기본적인 나이키 반팔 티셔츠라 무난하게 입기 좋아요.")
                    .build()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
