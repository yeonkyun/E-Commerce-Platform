package edu.sunmoon.category;

import edu.sunmoon.dto.Category;
import edu.sunmoon.service.CategoryService;

public class CategorySelectById {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();
        try {
            Category category = service.get(5000);
            System.out.println(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
