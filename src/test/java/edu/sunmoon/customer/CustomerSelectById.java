package edu.sunmoon.customer;

import edu.sunmoon.dto.Customer;
import edu.sunmoon.service.CustomerService;

public class CustomerSelectById {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        try {
            Customer customer = service.get("customer999");
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
