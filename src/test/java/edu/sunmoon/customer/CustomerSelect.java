package edu.sunmoon.customer;

import edu.sunmoon.dto.Customer;
import edu.sunmoon.service.CustomerService;

import java.util.List;

public class CustomerSelect {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        try {
            List<Customer> list = service.get();
            for (Customer customer : list) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
