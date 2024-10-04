package edu.sunmoon.address;

import edu.sunmoon.service.AddressService;

public class AddressSelectByCustomerId {
    public static void main(String[] args) {
        AddressService service = new AddressService();
        try {
            service.getByCustomerId("customer999").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
