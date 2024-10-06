package edu.sunmoon.product;

import edu.sunmoon.dto.Product;
import edu.sunmoon.service.ProductService;

public class ProductUpdate {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        try {
            System.out.println(productService.modify(Product.builder()
                    .id(158)
                    .categoryId(2007)
                    .name("나이키 반팔")
                    .description("나이키 반팔 티셔츠")
                    .price(30000)
                    .stockQuantity(60)
                    .isSelling(true)
                    .build()));
            System.out.println(productService.get(158));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
