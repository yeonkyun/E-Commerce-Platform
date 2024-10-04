package edu.sunmoon.customer;

import edu.sunmoon.dto.Customer;
import edu.sunmoon.service.CustomerService;

public class CustomerUpdate {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        try {
            Customer customer = Customer.builder()
                    .id("customer999")
                    .password("password999")
                    .phone("010-5213-0917")
                    .email("jungyk411@mail.sunmoon.ac.kr")
                    .level("VIP")
                    .build();
            service.modify(customer);
            System.out.println("Updated: " + service.get("customer999"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
