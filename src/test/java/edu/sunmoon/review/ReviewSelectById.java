package edu.sunmoon.review;

import edu.sunmoon.service.ReviewService;

public class ReviewSelectById {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        try {
            System.out.println(reviewService.get(48));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
