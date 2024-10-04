package edu.sunmoon.customer;

import edu.sunmoon.dto.Customer;
import edu.sunmoon.service.CustomerService;

import java.util.List;

public class CustomerSelectByName {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        try {
            List<Customer> list = service.getByName("홍길동");
            for (Customer customer : list) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}