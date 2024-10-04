package edu.sunmoon.address;

import edu.sunmoon.service.AddressService;

public class AddressDelete {
    public static void main(String[] args) {
        AddressService service = new AddressService();
        try {
            boolean result = service.remove(290);
            System.out.println("Deleted: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
