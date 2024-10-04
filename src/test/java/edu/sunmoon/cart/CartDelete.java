package edu.sunmoon.cart;

import edu.sunmoon.service.CartService;

public class CartDelete {
    public static void main(String[] args) {
        CartService service = new CartService();
        try {
            boolean result = service.remove(65);
            System.out.println("Deleted: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
