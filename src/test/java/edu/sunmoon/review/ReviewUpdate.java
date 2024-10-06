package edu.sunmoon.review;

import edu.sunmoon.dto.Review;
import edu.sunmoon.service.ReviewService;

public class ReviewUpdate {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        try {
            System.out.println(reviewService.modify(Review.builder()
                    .id(51)
                    .rating(4.5f)
                    .content("기본적인 나이키 반팔 티셔츠라 무난하게 입기 좋아요. 다만 가격이 조금 비싸다고 느꼈습니다.")
                    .build()));
            System.out.println(reviewService.get(51));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
