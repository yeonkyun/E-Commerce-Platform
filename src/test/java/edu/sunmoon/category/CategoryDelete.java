package edu.sunmoon.category;

import edu.sunmoon.service.CategoryService;

public class CategoryDelete {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();
        try {
            boolean result = service.remove(5000);
            System.out.println("Deleted: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
