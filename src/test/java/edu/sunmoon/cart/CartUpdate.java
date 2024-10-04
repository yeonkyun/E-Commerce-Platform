package edu.sunmoon.cart;

import edu.sunmoon.dto.Cart;
import edu.sunmoon.service.CartService;

public class CartUpdate {
    public static void main(String[] args) {
        CartService service = new CartService();
        try {
            Cart cart = Cart.builder()
                    .id(62)
                    .quantity(2)
                    .build();
            service.modify(cart);
            System.out.println("Updated: " + service.get(62));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
