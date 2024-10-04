package edu.sunmoon.cart;

import edu.sunmoon.dto.Cart;
import edu.sunmoon.service.CartService;

public class CartInsert {
    public static void main(String[] args) {
        CartService service = new CartService();
        Cart cart = Cart.builder()
                .customerId("customer999")
                .productId(1)
                .quantity(1)
                .build();
        try {
            Cart result = service.add(cart);
            System.out.println("Inserted: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
