package edu.sunmoon.product;

import edu.sunmoon.dto.Product;
import edu.sunmoon.service.ProductService;

import java.util.List;

public class ProductSelect {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        try {
            List<Product> products = productService.get();
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
