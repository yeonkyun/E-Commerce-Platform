package edu.sunmoon.address;

import edu.sunmoon.dto.Address;
import edu.sunmoon.service.AddressService;

import java.util.List;

public class AddressSelect {
    public static void main(String[] args) {
        AddressService service = new AddressService();
        try {
            List<Address> list = service.get();
            for (Address address : list) {
                System.out.println(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
