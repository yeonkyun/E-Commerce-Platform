package edu.sunmoon.review;

import edu.sunmoon.service.ReviewService;

public class ReviewDelete {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        try {
            System.out.println(reviewService.remove(999));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
