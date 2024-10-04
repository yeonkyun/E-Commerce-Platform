package edu.sunmoon.cart;

import edu.sunmoon.dto.Cart;
import edu.sunmoon.service.CartService;

import java.util.List;

public class CartSelect {
    public static void main(String[] args) {
        CartService service = new CartService();
        try {
            List<Cart> list = service.get();
            for (Cart cart : list) {
                System.out.println(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
