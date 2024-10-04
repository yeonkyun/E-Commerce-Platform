package edu.sunmoon.address;

import edu.sunmoon.dto.Address;
import edu.sunmoon.service.AddressService;

public class AddressSelectById {
    public static void main(String[] args) {
        AddressService service = new AddressService();
        try {
            Address address = service.get(90);
            System.out.println(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
