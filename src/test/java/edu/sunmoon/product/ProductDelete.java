package edu.sunmoon.product;

import edu.sunmoon.service.ProductService;

public class ProductDelete {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        try {
            boolean result = productService.remove(158);
            System.out.println(result);
            System.out.println(productService.get(158));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
