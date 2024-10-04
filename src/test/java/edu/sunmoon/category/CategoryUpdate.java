package edu.sunmoon.category;

import edu.sunmoon.dto.Category;
import edu.sunmoon.service.CategoryService;

public class CategoryUpdate {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();
        try {
            Category category = Category.builder()
                    .id(5000)
                    .parentsId(0)
                    .name("모자")
                    .build();
            service.modify(category);
            System.out.println("Updated: " + category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
