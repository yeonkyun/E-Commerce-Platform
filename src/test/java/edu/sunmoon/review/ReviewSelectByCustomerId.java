package edu.sunmoon.review;

import edu.sunmoon.dto.Review;
import edu.sunmoon.service.ReviewService;

import java.util.List;

public class ReviewSelectByCustomerId {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        try {
            List<Review> reviews = reviewService.getByCustomerId("customer067");
            for (Review review : reviews) {
                System.out.println(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
