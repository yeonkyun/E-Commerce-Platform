package edu.sunmoon.customer;

import edu.sunmoon.dto.Customer;
import edu.sunmoon.service.CustomerService;

public class CustomerInsert {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        Customer customer = Customer.builder()
                .id("customer999")
                .password("password999")
                .name("정연균")
                .phone("010-5213-0917")
                .email("jungyk411@sunmoon.ac.kr")
                .level("VIP")
                .build();
        try {
            Customer result = service.add(customer);
            System.out.println("Inserted: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}