package edu.sunmoon.product;

import edu.sunmoon.service.ProductService;

public class ProductSelectById {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        try {
            System.out.println(productService.get(158));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
