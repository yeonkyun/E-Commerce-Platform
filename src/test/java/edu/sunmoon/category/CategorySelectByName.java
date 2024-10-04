package edu.sunmoon.category;

import edu.sunmoon.service.CategoryService;

public class CategorySelectByName {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();
        try {
            System.out.println(service.getByName("신발"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
