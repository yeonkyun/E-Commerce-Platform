package edu.sunmoon.category;

import edu.sunmoon.dto.Category;
import edu.sunmoon.service.CategoryService;

import java.util.List;

public class CategorySelectByParentsId {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();
        int CategoryId = 1000;
        try {
            System.out.println(service.get(CategoryId));
            List<Category> list = service.getByParentsId(CategoryId);
            for (Category category : list) {
                System.out.println(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
