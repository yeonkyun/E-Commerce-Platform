package edu.sunmoon.category;

import edu.sunmoon.dto.Category;
import edu.sunmoon.service.CategoryService;

import java.util.List;

public class CategorySelect {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();
        try {
            List<Category> list = service.get();
            for (Category category : list) {
                System.out.println(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
