package edu.sunmoon.category;

import edu.sunmoon.dto.Category;
import edu.sunmoon.service.CategoryService;

public class CategoryInsert {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();
        try {
            Category category = Category.builder()
                    .id(5000)
                    .name("가방")
                    .build();
            service.add(category);
            System.out.println("Inserted + " + category);
            System.out.println(service.get(5000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
