package edu.sunmoon.product;

import edu.sunmoon.dto.Product;
import edu.sunmoon.service.ProductService;

public class ProductInsert {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        try {
            System.out.println(productService.add(Product.builder()
                    .categoryId(2007)
                    .name("나이키 반팔")
                    .description("나이키 반팔 티셔츠")
                    .price(30000)
                    .stockQuantity(100)
                    .isSelling(true)
                    .build()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
